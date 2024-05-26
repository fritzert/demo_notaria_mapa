package com.frodas.notaria.mapa.presentation.advice;

import org.springframework.http.ResponseEntity;

public class SuccessResponseHandler<T> {
    public static <T> ResponseEntity<SuccessResponse<T>> SUCCESS() {
        SuccessResponse<T> result = SuccessResponse.<T>builder()
                .build();
        return ResponseEntity.status(result.getStatusCode()).body(result);
    }

    public static <T> ResponseEntity<SuccessResponse<T>> SUCCESS(T data) {
        SuccessResponse<T> result = SuccessResponse.<T>builder()
                .data(data)
                .build();
        return ResponseEntity.status(result.getStatusCode()).body(result);
    }

    public static <T> ResponseEntity<SuccessResponse<T>> SUCCESS(Integer operationCode, T data) {
        SuccessResponse<T> result = SuccessResponse.<T>builder()
                .statusCode(operationCode)
                .data(data)
                .build();
        return ResponseEntity.status(result.getStatusCode()).body(result);
    }

    public static <T> ResponseEntity<SuccessResponse<T>> SUCCESS(Integer operationCode, String message) {
        SuccessResponse<T> result = SuccessResponse.<T>builder()
                .statusCode(operationCode)
                .message(message)
                .build();
        return ResponseEntity.status(result.getStatusCode()).body(result);
    }
}
