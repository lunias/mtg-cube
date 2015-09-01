package com.ethanaa.mtg.cube.ui.component;

import com.ethanaa.mtg.cube.model.Card;
import com.ethanaa.mtg.cube.model.Land;
import com.ethanaa.mtg.cube.model.exception.CopyException;
import com.ethanaa.mtg.cube.model.support.CardType;
import com.ethanaa.mtg.cube.model.support.ManaType;
import com.ethanaa.mtg.cube.service.CardService;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Player extends PlayerBase {

    private CardService cardService;

    private PlayerHand playerHand;
    private PlayerLandArea playerLandArea;
    private PlayerManaPool playerManaPool;
    private PlayerLibrary playerLibrary;

    @Autowired
    public Player(PlayerHand playerHand,
                  PlayerLibrary playerLibrary,
                  PlayerLandArea playerLandArea,
                  PlayerManaPool playerManaPool,
                  CardService cardService) {

        this.playerHand = playerHand;
        this.playerLandArea = playerLandArea;
        this.playerManaPool = playerManaPool;
        this.playerLibrary = playerLibrary;

        this.library = playerLibrary.getLibrary();
        this.hand = playerHand.getHand();
        this.manaPool = playerManaPool.getManaPool();

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

    public boolean canPlay(Card card) {

        if (card.getType() == CardType.LAND) {
            return true;
        }

        return hasEnoughMana(card);
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

    public PlayerManaPool getPlayerManaPool() {

        return playerManaPool;
    }

    public ObservableMap<ManaType, Integer> getManaTypeCounts() {

        return playerManaPool.getManaTypeCounts();
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
