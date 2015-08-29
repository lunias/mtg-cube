package com.ethanaa.mtg.cube;


public class CardQuantityTuple {

    private int quantity;

    private Card card;

    public CardQuantityTuple(int quantity, Card card) {

        this.quantity = quantity;
        this.card = card;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "CardQuantityTuple{" +
                "quantity=" + quantity +
                ", card=" + card +
                '}';
    }
}
