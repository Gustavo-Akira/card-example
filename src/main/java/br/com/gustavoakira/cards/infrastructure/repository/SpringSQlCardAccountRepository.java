package br.com.gustavoakira.cards.infrastructure.repository;

import br.com.gustavoakira.cards.domain.CardAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringSQlCardAccountRepository extends JpaRepository<CardAccount, String> {
}
