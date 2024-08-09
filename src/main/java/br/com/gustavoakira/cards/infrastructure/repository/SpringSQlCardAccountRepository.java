package br.com.gustavoakira.cards.infrastructure.repository;

import br.com.gustavoakira.cards.infrastructure.repository.entity.CardAccountEntity;
import br.com.gustavoakira.cards.infrastructure.repository.entity.CardHolderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringSQlCardAccountRepository extends JpaRepository<CardAccountEntity, String> {
    List<CardAccountEntity> findByCardHolder(CardHolderEntity entity);
}
