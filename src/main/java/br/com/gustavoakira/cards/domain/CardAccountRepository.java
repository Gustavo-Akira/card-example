package br.com.gustavoakira.cards.domain;

import java.util.Collections;
import java.util.List;

public interface CardAccountRepository {
    void save(List<CardAccount> cardAccounts);
    default void save(CardAccount cardAccount){
        save(Collections.singletonList(cardAccount));
    }
    CardAccount findById(String id);
    List<CardAccount> findAll();
}
