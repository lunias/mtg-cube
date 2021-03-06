package com.ethanaa.mtg.cube.ui.node;

import com.ethanaa.mtg.cube.model.Land;
import com.ethanaa.mtg.cube.model.exception.CopyException;
import javafx.scene.layout.StackPane;

public class LandNode extends StackPane {

    protected Land land;

    public LandNode(Land land) {

        this.land = land;

        initNode();
    }

    public LandNode(LandNode landNode) throws CopyException {

        this(Land.copy(landNode.getLand()));
    }

    private void initNode() {

        String css = "-fx-background-image: url(\"cards/" + land.getUrlName() + ".jpg\");" +
                "-fx-background-size: cover;";
        setStyle(css);

        setPrefWidth(156.0);
        setPrefHeight(222.5);

        setMaxWidth(156.0);
        setMaxHeight(222.5);
    }

    public void tap() {

        if (land.isTapped()) {
            setRotate(0.0);
            land.setIsTapped(false);
        } else {
            setRotate(90.0);
            land.setIsTapped(true);
        }
    }

    public boolean isTapped() {

        return land.isTapped();
    }

    public Land getLand() {
        return land;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LandNode landNode = (LandNode) o;

        return land.equals(landNode.land);
    }

    @Override
    public int hashCode() {
        return land.hashCode();
    }
}
