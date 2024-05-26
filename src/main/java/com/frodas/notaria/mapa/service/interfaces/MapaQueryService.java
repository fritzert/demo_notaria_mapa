package com.frodas.notaria.mapa.service.interfaces;

import com.frodas.notaria.mapa.presentation.dto.DistritoGisDto;
import com.frodas.notaria.mapa.presentation.dto.DistritoInfoDto;

public interface MapaQueryService {

	DistritoGisDto listarDistritos();

	DistritoInfoDto buscarDistritoPorId(String codDistrito);

}
