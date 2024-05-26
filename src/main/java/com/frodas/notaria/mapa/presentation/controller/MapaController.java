package com.frodas.notaria.mapa.presentation.controller;

import com.frodas.notaria.mapa.presentation.advice.SuccessResponse;
import com.frodas.notaria.mapa.presentation.advice.SuccessResponseHandler;
import com.frodas.notaria.mapa.presentation.doc.MapaDoc;
import com.frodas.notaria.mapa.presentation.dto.DistritoGisDto;
import com.frodas.notaria.mapa.presentation.dto.DistritoInfoDto;
import com.frodas.notaria.mapa.service.interfaces.MapaQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.frodas.notaria.mapa.util.constants.ConstantsPath.PATH_MAPA_NOTARIAL;

@RestController
@RequestMapping(PATH_MAPA_NOTARIAL)
@RequiredArgsConstructor
@Slf4j
public class MapaController implements MapaDoc {

    private final MapaQueryService notariaQueryService;

    @Override
    @GetMapping("/distritos")
    public ResponseEntity<SuccessResponse<DistritoGisDto>> listar() {
        DistritoGisDto distritoGisDto = notariaQueryService.listarDistritos();
        return SuccessResponseHandler.SUCCESS(distritoGisDto);
    }

    @Override
    @GetMapping("/distritos/{id}")
    public ResponseEntity<SuccessResponse<DistritoInfoDto>> listarPorId(@PathVariable("id") String codDistrito) {
        DistritoInfoDto distritoInfoDto = notariaQueryService.buscarDistritoPorId(codDistrito);
        return SuccessResponseHandler.SUCCESS(distritoInfoDto);
    }

}
