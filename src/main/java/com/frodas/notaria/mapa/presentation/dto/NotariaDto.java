package com.frodas.notaria.mapa.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotariaDto {

    private String id;
    private Integer notariaId;
    private String nombreCompleto;
    private String departamento;
    private String provincia;
    private String distrito;
    private String direccion;
    private String distritoId;
    private Boolean habilitado;
    private String estadoReapertura;
    private LocalDate fecInicioServicio;

}