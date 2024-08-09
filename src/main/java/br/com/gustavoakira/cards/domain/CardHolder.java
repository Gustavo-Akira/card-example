package br.com.gustavoakira.cards.domain;

import java.util.List;

public class CardHolder {
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private List<CardAccount> cardAccounts;

    public CardHolder(Long id, String name, String address, String phoneNumber, List<CardAccount> cardAccounts) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.cardAccounts = cardAccounts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<CardAccount> getCardAccounts() {
        return cardAccounts;
    }

    public void setCardAccounts(List<CardAccount> cardAccounts) {
        this.cardAccounts = cardAccounts;
    }

    public void addAccount(CardAccount account){
        this.cardAccounts.add(account);
    }

    public void removeAccount(CardAccount account){
        this.cardAccounts.remove(account);
    }
}
