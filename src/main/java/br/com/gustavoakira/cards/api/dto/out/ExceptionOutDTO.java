package br.com.gustavoakira.cards.api.dto.out;

import lombok.Data;

import java.time.LocalDateTime;


public record ExceptionOutDTO(String message,int status,LocalDateTime dateTime) {
}
