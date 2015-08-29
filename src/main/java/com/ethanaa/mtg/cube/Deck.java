package com.ethanaa.mtg.cube;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cards;

    public Deck(Card... cards) {

        this.cards = new ArrayList<>(Arrays.asList(cards));
    }

    public Deck(CardQuantityTuple... cardQuantityTuples) throws DeckInitializationException {

        try {

            this.cards = new ArrayList<>();

            for (CardQuantityTuple cardQuantityTuple : cardQuantityTuples) {

                int quantity = cardQuantityTuple.getQuantity();
                Card card = cardQuantityTuple.getCard();

                for (int i = 0; i < quantity; i++) {
                    cards.add(Card.copy(card));
                }
            }

        } catch (CopyException ce) {
            throw new DeckInitializationException(ce.getCause());
        }
    }

    public void shuffle() {

        Collections.shuffle(cards);
    }

    public Card draw() {

        try {
            return cards.remove(0);
        } catch (IndexOutOfBoundsException ioobe) {
            throw new EmptyDeckException("You cannot draw from an empty deck");
        }
    }

    public List<Card> draw(int numCards) {

        List<Card> drawn = new ArrayList<>();

        for (int i = 0; i < numCards; i++) {
            try {
                drawn.add(draw());
            } catch (EmptyDeckException ede) {
                return drawn;
            }
        }

        return drawn;
    }

    public Card peekTop(int numCardsDown) {

        try {
            return cards.get(numCardsDown);
        } catch (IndexOutOfBoundsException ioobe) {
            throw new EmptyDeckException("You cannot peek at an empty deck");
        }
    }

    public Card peekTop() {

        return peekTop(0);
    }

    public List<Card> peekTopN(int numCards) {

        List<Card> peeked = new ArrayList<>();

        for (int i = 0; i < numCards; i++) {
            try {
                peeked.add(peekTop(i));
            } catch (EmptyDeckException ede) {
                return peeked;
            }
        }

        return peeked;
    }

    public Card peekBottom(int numCardsUp) {

        try {
            return cards.get(cards.size() - 1 - numCardsUp);
        } catch (IndexOutOfBoundsException ioobe) {
            throw new EmptyDeckException("You cannot peek at an empty deck");
        }
    }

    public Card peekBottom() {

        return peekBottom(0);
    }

    public List<Card> peekBottomN(int numCards) {

        List<Card> peeked = new ArrayList<>();

        for (int i = 0; i < numCards; i++) {
            try {
                peeked.add(peekBottom(i));
            } catch (EmptyDeckException ede) {
                return peeked;
            }
        }

        return peeked;
    }

    public List<Card> getCards() {

        return cards;
    }

    public List<Card> getCardsOrdered() {

        List<Card> orderedCards = new ArrayList<>(cards);

        Collections.sort(orderedCards);

        return orderedCards;
    }

    public int size() {

        return cards.size();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (Card card : getCards()) {
            sb.append(card + "\n\n");
        }

        return sb.toString();
    }
}
