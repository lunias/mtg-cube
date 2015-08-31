package com.ethanaa.mtg.cube.component.zone;

import com.ethanaa.mtg.cube.component.Table;
import com.ethanaa.mtg.cube.component.node.CardNode;
import com.ethanaa.mtg.cube.service.CardService;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OpponentHandZone extends HBox {

    CardService cardService;

    @Autowired
    public OpponentHandZone(CardService cardService) {

        this.cardService = cardService;

        initZone();
    }

    private void initZone() {

        getStyleClass().add("opponentHand");
        setPadding(new Insets(5.0));
        setSpacing(5);
        setAlignment(Pos.CENTER);

        HBox.setHgrow(this, Priority.NEVER);

        setOnMouseEntered(me -> {
            AnchorPane.setTopAnchor(this, 0.0);
        });

        setOnMouseExited(me -> {
            AnchorPane.setTopAnchor(this, Table.HIDDEN_HAND_OFFSET);
        });

        getChildren().addAll(cardService.getCards().stream()
                .sorted()
                .limit(7)
                .map(card -> new CardNode(card))
                .collect(Collectors.toList()));
    }

}
