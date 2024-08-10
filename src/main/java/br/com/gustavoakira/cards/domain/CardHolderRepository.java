package br.com.gustavoakira.cards.domain;

import java.util.Collections;
import java.util.List;

public interface CardHolderRepository {
    void save(List<CardHolder> cardHolder);
    default void save(CardHolder cardHolder){
        save(Collections.singletonList(cardHolder));
    }
    CardHolder findById(Long id);
    List<CardHolder> findAll();
    CardHolder findByName(String name);
    void remove(String name);
}
