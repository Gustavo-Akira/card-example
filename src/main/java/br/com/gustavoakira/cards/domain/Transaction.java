package br.com.gustavoakira.cards.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Transaction(String transactionId, LocalDateTime transactionDate, BigDecimal amount, String type) {
}
