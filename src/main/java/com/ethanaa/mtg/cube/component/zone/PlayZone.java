package com.ethanaa.mtg.cube.component.zone;


import javafx.scene.layout.Pane;

public class PlayZone extends Pane {

    public PlayZone() {
        initZone();
    }

    private void initZone() {

        getStyleClass().add("playZone");
    }

}
