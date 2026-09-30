package br.com.florum.error;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleMethodArgumentNotValidException(
        MethodArgumentNotValidException exception,
        HttpServletRequest request
    ) {
        BindingResult bindingResult = exception.getBindingResult();
        Map<String, String> validationErrors = new HashMap<>();
        for(FieldError fieldError: bindingResult.getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new ApiError(
            HttpStatus.BAD_REQUEST.value(),
            "ValidationError",
            request.getServletPath(),
            validationErrors
        );
    }

    @ExceptionHandler(value = {ResponseStatusException.class})
    public ResponseEntity<ApiError> handleResponseStatusException(
            ResponseStatusException exception,
            HttpServletRequest request
    ) {
        return ResponseEntity
            .status(exception.getStatusCode())
            .body( new ApiError(
                exception.getStatusCode().value(),
                exception.getReason(),
                request.getServletPath()
            ));
    }
}
