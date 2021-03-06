package com.ethanaa.mtg.cube.ui.component;

import com.ethanaa.mtg.cube.game.Player;
import com.ethanaa.mtg.cube.ui.component.layer.ManaPoolLayer;
import com.ethanaa.mtg.cube.ui.component.layer.ZoomLayer;
import com.ethanaa.mtg.cube.ui.component.zone.*;
import javafx.scene.layout.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Table extends StackPane {

    public static final double HIDDEN_HAND_OFFSET = -200.0;

    private OpponentHandZone opponentHandZone;

    private Player player;
    private HandZone handZone;
    private LandZone landZone;

    private ZoomLayer zoomLayer;
    private ManaPoolLayer manaPoolLayer;

    @Autowired
    public Table(OpponentHandZone opponentHandZone,
                 Player player, HandZone handZone, LandZone landZone,
                 ZoomLayer zoomLayer, ManaPoolLayer manaPoolLayer) {

        this.opponentHandZone = opponentHandZone;

        this.player = player;
        this.handZone = handZone;
        this.landZone = landZone;

        this.zoomLayer = zoomLayer;
        this.manaPoolLayer = manaPoolLayer;

        player.initializePlayer();

        initComponent();
    }

    private void initComponent() {

        getChildren().addAll(
                createTable(),
                createHands(),
                createEffectsOverlay(),
                zoomLayer,
                manaPoolLayer
                );
    }

    private VBox createTable() {

        VBox table = new VBox();

        OpponentLandZone opponentLandZone = new OpponentLandZone();
        VBox.setVgrow(opponentLandZone, Priority.ALWAYS);

        OpponentPlayZone opponentPlayZone = new OpponentPlayZone();
        VBox.setVgrow(opponentPlayZone, Priority.ALWAYS);

        PlayZone playZone = new PlayZone();
        VBox.setVgrow(playZone, Priority.ALWAYS);

        table.getChildren().addAll(
                opponentLandZone,
                opponentPlayZone,
                playZone,
                landZone
        );

        return table;
    }

    private AnchorPane createHands() {

        AnchorPane handsAnchor = new AnchorPane();
        handsAnchor.getStyleClass().add("handsAnchor");
        handsAnchor.setPickOnBounds(false);
        handsAnchor.setMaxWidth(600.0);

        handsAnchor.getChildren().addAll(
                opponentHandZone,
                handZone
        );

        AnchorPane.setTopAnchor(opponentHandZone, HIDDEN_HAND_OFFSET);
        AnchorPane.setBottomAnchor(handZone, HIDDEN_HAND_OFFSET);

        return handsAnchor;
    }

    private AnchorPane createEffectsOverlay()  {

        AnchorPane effectsOverlay = new AnchorPane();
        effectsOverlay.setVisible(false);
        effectsOverlay.setMouseTransparent(true);

        return effectsOverlay;
    }
}
