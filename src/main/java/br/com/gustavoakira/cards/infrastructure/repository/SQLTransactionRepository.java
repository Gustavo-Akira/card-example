package br.com.gustavoakira.cards.infrastructure.repository;

import br.com.gustavoakira.cards.domain.Transaction;
import br.com.gustavoakira.cards.domain.TransactionRepository;
import br.com.gustavoakira.cards.infrastructure.repository.entity.TransactionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class SQLTransactionRepository implements TransactionRepository {

    @Autowired
    private SpringSQLTransactionRepository repository;

    @Override
    public void save(List<Transaction> transactions) {
        transactions.forEach(transaction -> {
            transaction.makeTransaction();
            this.repository.save(TransactionEntity.fromDomain(transaction));
        });
    }

    @Override
    public Transaction findById(String id) {
        return this.repository.findById(id).orElseThrow().toDomain();
    }

    @Override
    public List<Transaction> findAll() {
        return this.repository.findAll().stream().map(TransactionEntity::toDomain).toList();
    }

    @Override
    public void remove(String id) {
        this.repository.deleteById(id);
    }
}
