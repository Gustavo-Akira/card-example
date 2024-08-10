package br.com.gustavoakira.cards.api.dto.in;

import br.com.gustavoakira.cards.domain.CardAccount;
import br.com.gustavoakira.cards.domain.Transaction;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record CreateTransaction(
        @NotNull
        LocalDateTime transactionDate,
        @DecimalMin(value = "0.0", inclusive = false)
        @Digits(integer=Integer.MAX_VALUE, fraction=2)
        BigDecimal amount,
        @NotNull
        @NotEmpty
        String type,
        @NotNull
        @NotEmpty
        String accountNumber
){
    public Transaction toDomain() {
        CardAccount account = new CardAccount();
        account.setAccountNumber(accountNumber);
        return new Transaction(transactionDate,amount,type,account);
    }
}
