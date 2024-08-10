package br.com.gustavoakira.cards.infrastructure.resource;

import br.com.gustavoakira.cards.api.dto.out.ExceptionOutDTO;
import br.com.gustavoakira.cards.domain.exception.BalanceNotEnoughException;
import br.com.gustavoakira.cards.domain.exception.CardNotValidException;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionOutDTO> notValid(MethodArgumentNotValidException exception){
        List<String> errors = exception.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        ExceptionOutDTO exceptionOutDTO = new ExceptionOutDTO(Strings.join(errors,'\n'), 400, LocalDateTime.now());
        return ResponseEntity.badRequest().body(exceptionOutDTO);
    }




    @ExceptionHandler({BalanceNotEnoughException.class, CardNotValidException.class})
    public ResponseEntity<ExceptionOutDTO> notValidActions(NoSuchElementException exception){
        ExceptionOutDTO exceptionOutDTO = new ExceptionOutDTO(exception.getMessage(), 400, LocalDateTime.now());
        return ResponseEntity.badRequest().body(exceptionOutDTO);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ExceptionOutDTO> notFound(NoSuchElementException exception){
        ExceptionOutDTO exceptionOutDTO = new ExceptionOutDTO(exception.getMessage(), 404, LocalDateTime.now());
        return ResponseEntity.status(404).body(exceptionOutDTO);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionOutDTO> general(Exception exception){
        ExceptionOutDTO exceptionOutDTO = new ExceptionOutDTO(exception.getMessage(), 500, LocalDateTime.now());
        return ResponseEntity.internalServerError().body(exceptionOutDTO);
    }
}
