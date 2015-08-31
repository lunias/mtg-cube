package com.ethanaa.mtg.cube.model;


import com.ethanaa.mtg.cube.model.support.ManaType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

public class ManaPool {

    private ObservableMap<ManaType, Integer> manaTypeCounts;

    public ManaPool() {

        this.manaTypeCounts = FXCollections.observableHashMap();
    }

    public int getManaCount(ManaType manaType) {

        Integer manaCount = manaTypeCounts.get(manaType);
        if (manaCount == null) {
            return 0;
        }

        return manaCount;
    }

    public void add(ManaType manaType, int quantity) {

        Integer numExisting = manaTypeCounts.get(manaType);
        if (numExisting == null) numExisting = 0;

        manaTypeCounts.put(manaType, numExisting + quantity);
    }

    public void add(ManaType manaType) {

        add(manaType, 1);
    }

    public void remove(ManaType manaType, int quantity) {

        Integer numExisting = manaTypeCounts.get(manaType);
        if (numExisting == null) numExisting = 0;

        quantity = numExisting - quantity;

        manaTypeCounts.put(manaType, quantity > 0 ? quantity : 0);
    }

    public void remove(ManaType manaType) {

        remove(manaType, 1);
    }

    public void removeAll(ManaType manaType) {

        manaTypeCounts.put(manaType, 0);
    }

    public void clear() {

        manaTypeCounts.clear();
    }

    public ObservableMap<ManaType, Integer> getManaTypeCounts() {

        return manaTypeCounts;
    }
}
