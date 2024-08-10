package br.com.gustavoakira.cards.api.dto.out;

import br.com.gustavoakira.cards.domain.CardAccount;
import br.com.gustavoakira.cards.domain.CardHolder;

import java.util.List;
import java.util.stream.Collectors;

public record CardHolderOutDTO(
        Long id,
        String name,
        String address,
        String phoneNumber,
        List<CardAccountOutDTO> cardAccounts) {
        public static CardHolderOutDTO fromDomain(CardHolder holder){
            return new CardHolderOutDTO(holder.getId(),holder.getName(), holder.getAddress(), holder.getPhoneNumber(), holder.getCardAccounts().stream().map(CardAccountOutDTO::fromDomain).collect(Collectors.toList()));
        }
}
