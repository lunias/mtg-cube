package com.ethanaa.mtg.cube.ui.component.zone;

import com.ethanaa.mtg.cube.ui.component.Player;
import com.ethanaa.mtg.cube.ui.component.Table;
import com.ethanaa.mtg.cube.ui.component.layer.ZoomLayer;
import com.ethanaa.mtg.cube.ui.node.CardNode;
import com.ethanaa.mtg.cube.model.Card;
import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HandZone extends HBox {

    private Player player;
    private ZoomLayer zoomLayer;

    @Autowired
    public HandZone(Player player, ZoomLayer zoomLayer) {

        this.player = player;
        this.zoomLayer = zoomLayer;

        initZone();
    }

    private void initZone() {

        getStyleClass().add("hand");
        setPadding(new Insets(5.0));
        setSpacing(5);
        setAlignment(Pos.CENTER);

        HBox.setHgrow(this, Priority.NEVER);

        setOnMouseEntered(me -> {
            AnchorPane.setBottomAnchor(this, 0.0);
        });

        setOnMouseExited(me -> {
            AnchorPane.setBottomAnchor(this, Table.HIDDEN_HAND_OFFSET);
        });

        player.getPlayerHand().getCards().addListener((ListChangeListener.Change<? extends Card> c) -> {
            while (c.next()) {
                if (c.wasPermutated()) {

                    getChildren().clear();
                    getChildren().addAll(createHandCards(player.getPlayerHand().getCards().toArray(new Card[]{})));

                } else if (c.wasUpdated()) {
                    // update item

                } else {
                    for (Card card : c.getRemoved()) {
                        getChildren().remove(new CardNode(card));
                    }
                    for (Card card : c.getAddedSubList()) {
                        getChildren().add(createHandCard(card));
                    }
                }
            }
        });
    }

    private CardNode createHandCard(Card card) {

        CardNode node = new CardNode(card);

        node.setOnMousePressed(me -> {
            if (me.getButton() == MouseButton.PRIMARY) {
                player.play(node.getCard());
            } else if (me.getButton() == MouseButton.SECONDARY) {
                zoomLayer.zoomIn(node, 2.0);
            }
        });

        node.setOnMouseReleased(me -> {
            zoomLayer.zoomOut();
        });

        return node;
    }

    private List<CardNode> createHandCards(Card... cards) {

        List<CardNode> cardNodes = new ArrayList<>();
        for (Card card : cards) {
            cardNodes.add(createHandCard(card));
        }

        return cardNodes;
    }
}

