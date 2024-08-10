package br.com.gustavoakira.cards.infrastructure.repository;

import br.com.gustavoakira.cards.domain.CardAccount;
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

    @Autowired
    private SQLCardAccountRepository cardAccountRepository;

    @Override
    public void save(List<Transaction> transactions) {
        transactions.forEach(transaction -> {
            transaction.setAccount(cardAccountRepository.findById(transaction.getAccount().getAccountNumber()));
            TransactionEntity old = this.repository.findById(transaction.getTransactionId()).orElse(null);
            if(old != null){
                CardAccount account = transaction.getAccount();
                if (old.getType().equals("Positivo")) {
                    account.setBalance(account.getBalance().subtract(old.getAmount()));
                } else {
                    account.setBalance(account.getBalance().add(old.getAmount()));
                }
                transaction.setAccount(account);
            }
            transaction.makeTransaction();
            this.cardAccountRepository.save(transaction.getAccount());
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
        Transaction old = this.findById(id);
        CardAccount account = old.getAccount();
        if (old.getType().equals("Positivo")) {
            account.setBalance(account.getBalance().subtract(old.getAmount()));
        } else {
            account.setBalance(account.getBalance().add(old.getAmount()));
        }
        this.cardAccountRepository.save(account);
        this.repository.deleteById(id);
    }
}
