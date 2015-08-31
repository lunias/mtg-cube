package com.ethanaa.mtg.cube.ui.component;


import com.ethanaa.mtg.cube.model.Card;
import com.ethanaa.mtg.cube.model.Hand;
import com.ethanaa.mtg.cube.model.Library;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;

import java.util.List;

public abstract class PlayerBase {

    private SimpleStringProperty name = new SimpleStringProperty("");

    private SimpleIntegerProperty lifeTotal = new SimpleIntegerProperty(20);

    protected Library library;

    protected Hand hand;

    //protected ManaPool manaPool;

    public PlayerBase() {

    }

    public void shuffleLibrary() {

        library.shuffle();
    }

    public List<Card> drawFromLibrary(int numToDraw) {

        return library.draw(numToDraw);
    }

    public Card drawFromLibrary() {

        return library.draw();
    }

    public List<Card> peekAtTopOfLibrary(int numToPeek) {

        return library.peekTopN(numToPeek);
    }

    public Card peekAtTopOfLibrary() {

        return library.peekTop();
    }

    public List<Card> peekAtBottomOfLibrary(int numToPeek) {

        return library.peekBottomN(numToPeek);
    }

    public Card peekAtBottomOfLibrary() {

        return library.peekBottom();
    }

    public void addCardsToLibrary(Card... cards) {

        library.addCards(cards);
    }

    public void addCardsToHand(Card... cards) {

        hand.addCards(cards);
        FXCollections.sort(hand.getCards());
    }

    public int modifyLifeTotal(int numLifePoints) {

        this.lifeTotal.set(lifeTotal.getValue() + numLifePoints);

        return lifeTotal.get();
    }

    public SimpleStringProperty getNameProperty() {
        return name;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

}
