package com.frodas.notaria.mapa.presentation.doc;

import com.frodas.notaria.mapa.presentation.advice.SuccessResponse;
import com.frodas.notaria.mapa.presentation.dto.DistritoGisDto;
import com.frodas.notaria.mapa.presentation.dto.DistritoInfoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "MapaController", description = "REST API for notaria information.")
public interface MapaDoc {

    @Operation(summary = "Listar Distritos Notariales")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = DistritoGisDto.class))}),
            @ApiResponse(responseCode = "204", description = "Petición exitosa, pero sin resultados", content = @Content),
            @ApiResponse(responseCode = "500", description = "Ha ocurrido un error al procesar la información", content = @Content)
    })
    ResponseEntity<SuccessResponse<DistritoGisDto>> listar();

    @Operation(summary = "Obtener Detalle de Distrito")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = DistritoInfoDto.class))}),
            @ApiResponse(responseCode = "204", description = "Petición exitosa, pero sin resultados", content = @Content),
            @ApiResponse(responseCode = "500", description = "Ha ocurrido un error al procesar la información", content = @Content)
    })
    ResponseEntity<SuccessResponse<DistritoInfoDto>> listarPorId(String codDistrito);

}
