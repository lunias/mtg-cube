package com.ethanaa.mtg.cube.ui.component;

import com.ethanaa.mtg.cube.model.Card;
import com.ethanaa.mtg.cube.model.Hand;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Component;

@Component
public class PlayerHand {

    private Hand hand = new Hand();

    public Hand getHand() {
        return hand;
    }

    public ObservableList<Card> getCards() {
        return hand.getCards();
    }
}
