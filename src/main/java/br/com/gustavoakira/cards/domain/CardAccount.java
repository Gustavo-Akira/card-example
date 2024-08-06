package br.com.gustavoakira.cards.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CardAccount(String accountNumber, String cardHolderName, BigDecimal balance, String cardType, String expirationDate) {

    public static CardAccount createAccount(String cardHolderName, BigDecimal initialValue, String type, LocalDateTime expiration) {

    }
}
