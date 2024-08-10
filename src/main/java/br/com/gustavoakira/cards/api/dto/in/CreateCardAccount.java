package br.com.gustavoakira.cards.api.dto.in;

import br.com.gustavoakira.cards.domain.CardAccount;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CreateCardAccount(@NotNull
                                @NotEmpty
                                String cardHolderName,
                                @DecimalMin(value = "0.0")
                                @Digits(integer=Integer.MAX_VALUE, fraction=2)
                                BigDecimal balance,
                                @NotEmpty
                                @NotNull
                                String cardType,
                                @NotNull
                                LocalDateTime expirationDate) {
    public CardAccount toDomain(){
        return CardAccount.createAccount(cardHolderName,balance,cardType,expirationDate);
    }

}
