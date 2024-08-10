package br.com.gustavoakira.cards.api.dto.out;

import br.com.gustavoakira.cards.domain.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionOutDTO(
        String transactionId,
        LocalDateTime transactionDate,
        BigDecimal amount,
        String type,
        String accountNumber
) {
    public static TransactionOutDTO fromDomain(Transaction transaction){
        return new TransactionOutDTO(transaction.getTransactionId(), transaction.getTransactionDate(),transaction.getAmount(),transaction.getType(),transaction.getAccount().getAccountNumber());
    }
}
