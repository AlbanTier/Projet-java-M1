package ila.api;

import ila.api.dto.ApiError;
import ila.api.dto.ErrorCodeEnum;
import ila.api.exception.IdMismatchException;
import ila.api.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class MyControllerAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {ResourceNotFoundException.class})
    protected ApiError handleNotFound(ResourceNotFoundException ex, WebRequest request) {
        return ApiError.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(ex.getMessage())
                .error(ErrorCodeEnum.RESOURCE_NOT_FOUND)
                .build();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {IdMismatchException.class})
    protected ApiError handleBadRequest(IdMismatchException ex, WebRequest request) {
        return ApiError.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(ex.getMessage())
                .error(ErrorCodeEnum.ID_MISMATCH)
                .build();
    }
}
