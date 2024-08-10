package br.com.gustavoakira.cards.api.dto.in;

import br.com.gustavoakira.cards.domain.CardAccount;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record UpdateCardAccount(
        @NotNull
        @NotEmpty
        String accountNumber,
        @NotNull
        @NotEmpty
        String cardHolderName,
        @DecimalMin(value = "0.0", inclusive = false)
        @Digits(integer=Integer.MAX_VALUE, fraction=2)
        BigDecimal balance,
        @NotEmpty
        @NotNull
        String cardType,
        @NotNull
        LocalDateTime expirationDate){
    public CardAccount toDomain(){
            return new CardAccount(accountNumber,cardHolderName,balance,cardType,expirationDate);
    }
}
