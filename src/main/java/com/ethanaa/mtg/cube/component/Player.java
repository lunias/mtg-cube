package com.ethanaa.mtg.cube.component;

import com.ethanaa.mtg.cube.model.Card;
import com.ethanaa.mtg.cube.model.Land;
import com.ethanaa.mtg.cube.model.exception.CopyException;
import com.ethanaa.mtg.cube.service.CardService;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Player extends PlayerBase {

    private CardService cardService;

    private PlayerHand playerHand;
    private PlayerLandArea playerLandArea;
    private PlayerLibrary playerLibrary;

    @Autowired
    public Player(PlayerHand playerHand,
                  PlayerLibrary playerLibrary,
                  PlayerLandArea playerLandArea,
                  CardService cardService) {

        this.playerHand = playerHand;
        this.playerLandArea = playerLandArea;
        this.playerLibrary = playerLibrary;

        this.library = playerLibrary.getLibrary();
        this.hand = playerHand.getHand();

        this.cardService = cardService;
    }

    public void initializePlayer() {

        addCardsToLibrary(cardService.getCards().toArray(new Card[]{}));

        Card plains = cardService.getCard("Plains");

        try {
            for (int i = 0; i < 10; i++) {
                addCardsToLibrary(Card.copy(plains));
            }
        } catch (CopyException ce) {

        }

        shuffleLibrary();

        drawFromLibraryToHand(7);
    }

    public void drawFromLibraryToHand() {

        addCardsToHand(drawFromLibrary());
    }

    public void drawFromLibraryToHand(int numToDraw) {

        addCardsToHand(drawFromLibrary(numToDraw).toArray(new Card[]{}));
    }

    public void play(Card card) {

        if (card instanceof Land) {
            getPlayerHand().getCards().remove(card);
            playerLandArea.getLandArea().addLand((Land) card);
        }
    }

    public PlayerHand getPlayerHand() {

        return playerHand;
    }

    public PlayerLandArea getPlayerLandArea() {

        return playerLandArea;
    }

    public Map<Integer, ObservableList<Land>> getLandStackMap() {

        return playerLandArea.getLandStackMap();
    }

    public PlayerLibrary getPlayerLibrary() {

        return playerLibrary;
    }

    public ObservableList<Card> getLibraryCards() {

        return playerLibrary.getLibrary().getCards();
    }
}
