package com.ethanaa.mtg.cube.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Hand {

    private ObservableList<Card> cards;

    public Hand() {
        this.cards = FXCollections.observableArrayList();
    }

    public void addCards(Card... cards) {

        this.cards.addAll(Arrays.asList(cards));
    }

    public ObservableList<Card> getCards() {

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

}
