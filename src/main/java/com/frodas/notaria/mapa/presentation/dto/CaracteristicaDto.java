package com.frodas.notaria.mapa.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CaracteristicaDto {

    private String type;
    private PropiedadesDto properties;
    private GeometriaDto geometry;

}
