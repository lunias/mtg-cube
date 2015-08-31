package com.ethanaa.mtg.cube.ui.component;

import com.ethanaa.mtg.cube.model.Land;
import com.ethanaa.mtg.cube.model.LandArea;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PlayerLandArea {

    private LandArea landArea = new LandArea();

    public LandArea getLandArea() {
        return landArea;
    }

    public Map<Integer, ObservableList<Land>> getLandStackMap() {
        return landArea.getLandStackMap();
    }

}
