package com.ethanaa.mtg.cube.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;
import java.util.Map;

public class LandArea {

    private Map<Integer, ObservableList<Land>> landStackMap;

    private int preferredStackSize = 4;

    public LandArea() {
        this.landStackMap = new HashMap<Integer, ObservableList<Land>>() {
            {
                for (int i = 0; i < 6; i++) {
                    put(i, FXCollections.observableArrayList());
                }
            }
        };
    }

    public void addLand(Land land) {

        ObservableList<Land> smallestLandStack = landStackMap.get(0);
        for (Map.Entry<Integer, ObservableList<Land>> entry : landStackMap.entrySet()) {

            ObservableList<Land> landStack = entry.getValue();

            if (landStack.isEmpty()) {

                landStack.add(land);
                return;

            } else if (stackContainsSameType(landStack, land) && landStack.size() < preferredStackSize) {

                landStack.add(land);
                return;
            }

            if (landStack.size() < smallestLandStack.size()) {
                smallestLandStack = landStack;
            }
        }

        smallestLandStack.add(land);
    }

    private boolean stackContainsSameType(ObservableList<Land> landStack, Land land) {

        for (Land stackLand : landStack) {
            if (stackLand.getProduces().equals(land.getProduces())) {
                return true;
            }
        }

        return false;
    }

    public Map<Integer, ObservableList<Land>> getLandStackMap() {
        return landStackMap;
    }

}
