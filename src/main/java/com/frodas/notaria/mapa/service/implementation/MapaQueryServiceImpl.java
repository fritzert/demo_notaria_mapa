package com.frodas.notaria.mapa.service.implementation;

import com.frodas.notaria.mapa.persistence.entity.DistritoEntity;
import com.frodas.notaria.mapa.persistence.repository.DistritoRepository;
import com.frodas.notaria.mapa.persistence.repository.NotariaRepository;
import com.frodas.notaria.mapa.presentation.dto.*;
import com.frodas.notaria.mapa.service.exception.BusinessException;
import com.frodas.notaria.mapa.service.exception.EmptyException;
import com.frodas.notaria.mapa.service.interfaces.MapaQueryService;
import com.frodas.notaria.mapa.util.LoggerHandler;
import com.frodas.notaria.mapa.util.mapper.EntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.frodas.notaria.mapa.presentation.dto.TipoCollectionType.*;
import static com.frodas.notaria.mapa.util.enums.StatusType.MESSAGE_NO_CONTENT;

@Service
@RequiredArgsConstructor
public class MapaQueryServiceImpl implements MapaQueryService {

    private final EntityMapper entityMapper;
    private final DistritoRepository distritoRepository;
    private final NotariaRepository notariaRepository;
    private LoggerHandler loggerHandler;

    @Override
    public DistritoGisDto listarDistritos() {
        loggerHandler = new LoggerHandler(Thread.currentThread().getStackTrace()[1].getMethodName());
        loggerHandler.startMethod();

        List<CaracteristicaDto> list = distritoRepository.findAllByHabilitado(Boolean.TRUE).stream()
                .map(x ->
                        CaracteristicaDto.builder()
                                .type(FEATURE.getString())
                                .properties(PropiedadesDto.builder()
                                        .codigo(x.getCodigo())
                                        .nombre(x.getNombre())
                                        .cantidad(notariaRepository.countByHabilitadoAndDistritoId(Boolean.TRUE, x.getCodigo()).toString())
                                        .urlImg(x.getUrlImg())
                                        .build())
                                .geometry(GeometriaDto.builder()
                                        .type(POINT.getString())
                                        .coordinates(Arrays.asList(x.getCoordLongitud(), x.getCoordLatitud()))
                                        .build())
                                .build())
                .toList();
        DistritoGisDto distritoGisDto = DistritoGisDto.builder().type(FEATURE_COLLECTION.getString()).features(list).build();

        loggerHandler.endMethod();
        return distritoGisDto;
    }

    @Override
    public DistritoInfoDto buscarDistritoPorId(String codDistrito) {
        loggerHandler = new LoggerHandler(Thread.currentThread().getStackTrace()[1].getMethodName());
        loggerHandler.startMethod();

        if (codDistrito.isBlank()) {
            loggerHandler.errorMethod("Id no puede ser vacio");
            throw new BusinessException("Id no puede ser vacio");
        }
        Optional<DistritoEntity> op = distritoRepository.findByHabilitadoAndCodigo(Boolean.TRUE, codDistrito);
        if (op.isEmpty()) {
            loggerHandler.infoMethod(MESSAGE_NO_CONTENT.getString());
            throw new EmptyException("No se encontraron distritos");
        }

        DistritoEntity distrito = op.get();
        List<NotariaDto> lista = entityMapper.entityListNotariaToApiListNotariaDto(notariaRepository.findAllByHabilitadoAndDistritoId(Boolean.TRUE, codDistrito));

        DistritoInfoDto distritoInfoDto = DistritoInfoDto.builder()
                .propiedades(PropiedadesDto.builder()
                        .codigo(distrito.getCodigo())
                        .nombre(distrito.getNombre())
                        .cantidad(notariaRepository.countByHabilitadoAndDistritoId(Boolean.TRUE, distrito.getCodigo()).toString())
                        .urlImg(distrito.getUrlImg())
                        .build())
                .listaNotaria(lista.isEmpty() ? new ArrayList<>() : lista)
                .build();

        loggerHandler.endMethod();
        return distritoInfoDto;
    }

}
