package br.com.gustavoakira.cards.domain;

import java.util.Collections;
import java.util.List;

public interface TransactionRepository {
    void save(List<Transaction> transactions);
    default void save(Transaction transaction){
        save(Collections.singletonList(transaction));
    }
    Transaction findById(String id);
    List<Transaction> findAll();
}
