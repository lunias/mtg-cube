package com.ethanaa.mtg.cube.ui.component.zone;


import javafx.scene.layout.Pane;

public class OpponentPlayZone extends Pane {

    public OpponentPlayZone() {
        initZone();
    }

    private void initZone() {

        getStyleClass().add("opponentPlayZone");
    }
}
