package com.ethanaa.mtg.cube.component.node;


import javafx.scene.layout.StackPane;

public class LibraryNode extends StackPane {

    public LibraryNode() {

        initNode();
    }

    private void initNode() {

        String css = "-fx-background-image: url(\"cards/Card%20Back.jpg\");" +
                "-fx-background-size: cover;";
        setStyle(css);

        setPrefWidth(156.0);
        setPrefHeight(222.5);

        setMaxWidth(156.0);
        setMaxHeight(222.5);
    }

}
