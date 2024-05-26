package com.frodas.notaria.mapa.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PropiedadesDto {

    private String codigo;
    private String nombre;
    private String cantidad;
    private String urlImg;

}
