package com.ethanaa.mtg.cube.ui.component.zone;


import com.ethanaa.mtg.cube.ui.component.Player;
import com.ethanaa.mtg.cube.ui.node.LibraryNode;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LibraryZone extends LibraryNode {

    private Player player;

    @Autowired
    public LibraryZone(Player player) {

        this.player = player;

        initZone();
    }

    private void initZone() {

        setOnMouseClicked(me -> {
            if (me.getButton() == MouseButton.PRIMARY) {
                player.drawFromLibraryToHand();
            }
        });

        getChildren().add(createCardCountOverlay());
    }

    private HBox createCardCountOverlay() {

        HBox cardCountOverlay = new HBox();

        cardCountOverlay.setPadding(new Insets(110.0, 0.0, 0.0, 0.0));

        cardCountOverlay.setAlignment(Pos.CENTER);

        Label cardCountLabel = new Label();
        cardCountLabel.getStyleClass().add("cardCountLabel");

        cardCountLabel.textProperty().bind(Bindings.format("%d",
                        Bindings.size(player.getLibraryCards())));

        cardCountOverlay.getChildren().add(cardCountLabel);

        return cardCountOverlay;
    }
}
