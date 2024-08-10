package br.com.gustavoakira.cards.api.dto.out;

import br.com.gustavoakira.cards.domain.CardAccount;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CardAccountOutDTO(
        String accountNumber,
        String cardHolderName,
        BigDecimal balance,
        String cardType,
        LocalDateTime expirationDate){
    public static CardAccountOutDTO fromDomain(CardAccount account){
        return new CardAccountOutDTO(account.getAccountNumber(), account.getCardHolderName(),account.getBalance(),account.getCardType(),account.getExpirationDate());
    }

}
