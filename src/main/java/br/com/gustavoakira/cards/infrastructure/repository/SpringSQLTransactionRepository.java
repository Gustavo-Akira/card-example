package br.com.gustavoakira.cards.infrastructure.repository;

import br.com.gustavoakira.cards.infrastructure.repository.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringSQLTransactionRepository extends JpaRepository<TransactionEntity, String> {
}
