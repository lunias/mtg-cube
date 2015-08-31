package com.ethanaa.mtg.cube.ui.component;

import com.ethanaa.mtg.cube.model.ManaPool;
import com.ethanaa.mtg.cube.model.support.ManaType;
import javafx.collections.ObservableMap;
import org.springframework.stereotype.Component;

@Component
public class PlayerManaPool {

    private ManaPool manaPool = new ManaPool();

    public ManaPool getManaPool() {
        return manaPool;
    }

    public ObservableMap<ManaType, Integer> getManaTypeCounts() {
        return manaPool.getManaTypeCounts();
    }
}
