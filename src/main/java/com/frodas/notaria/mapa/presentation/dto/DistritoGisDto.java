package com.frodas.notaria.mapa.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DistritoGisDto {

    private String type;
    private List<CaracteristicaDto> features;

}
