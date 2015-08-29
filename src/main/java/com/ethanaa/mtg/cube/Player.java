package com.ethanaa.mtg.cube;


import java.util.List;

public class Player {

    private String name;

    private int lifeTotal = 20;

    private Deck deck;

    public Player(String name, Deck deck) {

        this.name = name;
        this.deck = deck;

        shuffleDeck();
    }

    public void shuffleDeck() {

        deck.shuffle();
    }

    public List<Card> drawFromDeck(int numToDraw) {

        return deck.draw(numToDraw);
    }

    public Card drawFromDeck() {

        return deck.draw();
    }

    public List<Card> peekAtTopOfDeck(int numToPeek) {

        return deck.peekTopN(numToPeek);
    }

    public Card peekAtTopOfDeck() {

        return deck.peekTop();
    }

    public List<Card> peekAtBottomOfDeck(int numToPeek) {

        return deck.peekBottomN(numToPeek);
    }

    public Card peekAtBottomOfDeck() {

        return deck.peekBottom();
    }

    public int modifyLifeTotal(int numLifePoints) {

        return this.lifeTotal += numLifePoints;
    }

}
