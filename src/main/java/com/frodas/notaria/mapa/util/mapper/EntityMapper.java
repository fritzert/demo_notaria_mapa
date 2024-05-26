package com.frodas.notaria.mapa.util.mapper;

import com.frodas.notaria.mapa.persistence.entity.NotariaEntity;
import com.frodas.notaria.mapa.presentation.dto.NotariaDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EntityMapper {

    List<NotariaDto> entityListNotariaToApiListNotariaDto(List<NotariaEntity> entity);

}
