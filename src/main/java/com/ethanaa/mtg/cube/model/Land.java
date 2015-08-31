package com.ethanaa.mtg.cube.model;

import com.ethanaa.mtg.cube.model.support.CardType;
import com.ethanaa.mtg.cube.model.support.Expansion;
import com.ethanaa.mtg.cube.model.support.ManaCost;
import com.ethanaa.mtg.cube.model.support.Rarity;

import java.util.Set;

public abstract class Land extends Card implements Comparable<Card> {

    private ManaCost produces;

    private boolean isTapped = false;

    public Land(String name, ManaCost manaCost,
                CardType type, Set<String> subTypes,
                String text, Expansion expansion, Rarity rarity) {

        super(name, manaCost, type, subTypes, text, expansion, rarity);

        this.produces = manaCost;
    }

    public Land(String name, ManaCost produces) {

        super(name, produces);

        this.produces = produces;
    }

    public Land(Land land) {

        this(land.getName(), new ManaCost(land.getProduces()));
    }

    public ManaCost getProduces() {
        return produces;
    }

    public void setProduces(ManaCost produces) {
        this.produces = produces;
    }

    public boolean isTapped() {
        return isTapped;
    }

    public void setIsTapped(boolean isTapped) {
        this.isTapped = isTapped;
    }
}
