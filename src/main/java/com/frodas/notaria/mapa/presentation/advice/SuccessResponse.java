package com.frodas.notaria.mapa.presentation.advice;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessResponse<T> implements Serializable {
    @Builder.Default
//    private String message = "Process executed successfully";
    private String message = "Proceso ejecutado satisfactoriamente";
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();
    @Builder.Default
    private Integer statusCode = 200;
    private T data;

    public SuccessResponse(T body) {
        data = body;
    }

    public SuccessResponse(Integer operationCode, String message) {
        this.statusCode = operationCode;
        this.message = message;
    }
}
