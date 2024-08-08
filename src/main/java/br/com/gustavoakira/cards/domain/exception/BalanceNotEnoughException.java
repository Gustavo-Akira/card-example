package br.com.gustavoakira.cards.domain.exception;

import java.math.BigDecimal;

public class BalanceNotEnoughException extends RuntimeException{
        public BalanceNotEnoughException(BigDecimal balance, BigDecimal paymentValue){
            super("Your balance is not enough: Balance"+balance.toEngineeringString()+", Payment value: "+paymentValue.toEngineeringString());
        }
}

