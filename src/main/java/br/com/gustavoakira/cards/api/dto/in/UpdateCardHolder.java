package br.com.gustavoakira.cards.api.dto.in;

import br.com.gustavoakira.cards.domain.CardHolder;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UpdateCardHolder(
        @NotNull
        Long id,
        @NotEmpty
        String name,
        String address,
        String phoneNumber) {
    public CardHolder toDomain(){
        return new CardHolder(id,name,address,phoneNumber,null);
    }
}
