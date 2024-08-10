package br.com.gustavoakira.cards.api.dto.in;


import br.com.gustavoakira.cards.domain.CardHolder;
import jakarta.validation.constraints.NotEmpty;

public record CreateCardHolder(
        @NotEmpty
        String name,
        String address,
        String phoneNumber){
    public CardHolder toDomain(){
        return new CardHolder(name,address,phoneNumber,null);
    }
}
