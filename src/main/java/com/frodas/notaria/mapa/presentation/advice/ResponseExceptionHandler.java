package com.frodas.notaria.mapa.presentation.advice;

//@RestControllerAdvice
public class ResponseExceptionHandler
//        extends ResponseEntityExceptionHandler
        {

//    @Value("${app.show.log}")
//    private boolean showLog;
//
//    @ExceptionHandler(BusinessException.class)
//    public final ResponseEntity<ErrorDetail> handleBusinessException(BusinessException ex, WebRequest request) {
//        ErrorDetail errorDetail = ErrorDetail.builder().message(ex.getMessage()).excepcion(MESSAGE_ERROR_BUSINESS.getString()).timestamp(LocalDateTime.now()).statusCode(STATUS_CODE_ERROR.getNumber()).build();
//        return ResponseEntity.status(errorDetail.getStatusCode()).body(errorDetail);
//    }
//
//    @ExceptionHandler(DatabaseException.class)
//    public final ResponseEntity<ErrorDetail> handleDatabaseException(DatabaseException ex, WebRequest request) {
//        StringWriter excepcion = new StringWriter();
//        ex.printStackTrace(new PrintWriter(excepcion));
//        var detailException = showLog ? excepcion.toString() : MESSAGE_ERROR_BUSINESS.getString() + "- Enable show exception information";
//        ErrorDetail errorDetail = ErrorDetail.builder().message(ex.getMessage()).excepcion(detailException).timestamp(LocalDateTime.now()).statusCode(STATUS_CODE_ERROR.getNumber()).build();
//        return ResponseEntity.status(errorDetail.getStatusCode()).body(errorDetail);
//    }
//
////    // Validacion de parametros - @Valid
////    @Override
////    protected final ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
////        List<String> errors = new ArrayList<>();
////        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
////            errors.add(error.getField() + ": " + error.getDefaultMessage());
////        }
////        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
////            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
////        }
////        ErrorDetail errorDetail = ErrorDetail.builder().message(MESSAGE_REQUEST_INVALID_MESSAGE.getString()).timestamp(LocalDateTime.now()).statusCode(BAD_REQUEST.value()).errors(errors).build();
////        return ResponseEntity.status(BAD_REQUEST).body(errorDetail);
////    }
////
////    // Validacion de parametros - @PathVariable
////    @Override
////    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
////        ErrorDetail errorDetail = ErrorDetail.builder().message(MESSAGE_ERROR_EXCEPTION_BAD_REQUEST.getString()).timestamp(LocalDateTime.now()).statusCode(STATUS_CODE_ERROR_BUSINESS.getNumber()).build();
////        return new ResponseEntity<>(errorDetail, BAD_REQUEST);
////    }
////
////    // Validacion de parametros - @RequestParam
////    @Override
////    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
////        ErrorDetail errorDetail = ErrorDetail.builder().message(MESSAGE_ERROR_EXCEPTION_BAD_REQUEST.getString()).timestamp(LocalDateTime.now()).statusCode(STATUS_CODE_ERROR_BUSINESS.getNumber()).build();
////        return new ResponseEntity<>(errorDetail, BAD_REQUEST);
////    }
//
//    @ExceptionHandler(EmptyException.class)
//    public final ResponseEntity handleErrorSinResultadosException(EmptyException ex, WebRequest request) {
//        return ResponseEntity.status(STATUS_CODE_NO_CONTENT.getNumber()).header("Mensaje", MESSAGE_NO_CONTENT.getString()).body("");
//    }
//
//    // Validacion general
//    @ExceptionHandler(Exception.class)
//    public final ResponseEntity<Object> manejarTodasExcepciones(Exception ex, WebRequest request) {
//        ErrorDetail errorDetail = ErrorDetail.builder().message(ex.getMessage()).excepcion(request.getDescription(false)).timestamp(LocalDateTime.now()).statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
//        return new ResponseEntity<>(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

}
