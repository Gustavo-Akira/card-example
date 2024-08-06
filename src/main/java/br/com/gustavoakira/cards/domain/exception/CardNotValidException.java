package br.com.gustavoakira.cards.domain.exception;

public class CardNotValidException extends RuntimeException{
    public CardNotValidException(){
        super("this card is expired please contact us for more information");
    }
}
