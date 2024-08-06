package br.com.gustavoakira.cards.domain;

import java.util.List;

public record CardHolder(String id, String name, String address, String phoneNumber, List<CardAccount> cardAccounts) {
}
