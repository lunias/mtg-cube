package com.ethanaa.mtg.cube.component.node;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.util.List;

public class LandNodeStack extends VBox {

    ObservableList<Node> landNodes = FXCollections.observableArrayList();

    public LandNodeStack() {

        initNode();
    }

    public LandNodeStack(List<LandNode> landNodes) {

        this();

        this.landNodes = FXCollections.observableArrayList(landNodes);
    }

    private void initNode() {

        setSpacing(-200);

        Bindings.bindContentBidirectional(landNodes, getChildren());
    }

    public void addLandNode(LandNode landNode) {

        landNodes.add(landNode);
    }

    public void removeLandNode(LandNode landNode) {

        landNodes.remove(landNode);
    }

}
