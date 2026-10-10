package br.com.florum.error;

import br.com.florum.error.exceptions.BadRequestException;
import br.com.florum.error.exceptions.ConflictException;
import br.com.florum.error.exceptions.NotFoundException;
import br.com.florum.error.exceptions.UnprocessableException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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

    @ExceptionHandler(value = {BadRequestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleBadRequestException(
        BadRequestException exception,
        HttpServletRequest request
    ) {
        return new ApiError(
            HttpStatus.BAD_REQUEST.value(),
            exception.getMessage(),
            request.getServletPath()
        );
    }

    @ExceptionHandler(value = {NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleNotFoundException(
        NotFoundException exception,
        HttpServletRequest request
    ) {
        return new ApiError(
            HttpStatus.NOT_FOUND.value(),
            exception.getMessage(),
            request.getServletPath()
        );
    }

    @ExceptionHandler(value = {ConflictException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiError handleConflictExceptionException(
        ConflictException exception,
        HttpServletRequest request
    ) {
        return new ApiError(
            HttpStatus.CONFLICT.value(),
            exception.getMessage(),
            request.getServletPath()
        );
    }


    @ExceptionHandler(value = {UnprocessableException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_CONTENT)
    public ApiError handleUnprocessableExceptionException(
        UnprocessableException exception,
        HttpServletRequest request
    ) {
        return new ApiError(
            HttpStatus.UNPROCESSABLE_CONTENT.value(),
            exception.getMessage(),
            request.getServletPath()
        );
    }
}
