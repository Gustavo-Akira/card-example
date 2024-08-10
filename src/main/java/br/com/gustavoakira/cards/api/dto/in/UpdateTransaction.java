package br.com.gustavoakira.cards.api.dto.in;

import br.com.gustavoakira.cards.domain.CardAccount;
import br.com.gustavoakira.cards.domain.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record UpdateTransaction(
        String transactionId,
        LocalDateTime transactionDate,
        BigDecimal amount,
        String type,
        String accountNumber
) {
    public Transaction toDomain(){
        CardAccount account = new CardAccount();
        account.setAccountNumber(accountNumber);
        return new Transaction(transactionId,transactionDate,amount,type,account);
    }
}
