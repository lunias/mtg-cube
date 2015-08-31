package com.ethanaa.mtg.cube.model;


import com.ethanaa.mtg.cube.model.support.ManaCost;
import com.ethanaa.mtg.cube.model.support.ManaQuantityTuple;
import com.ethanaa.mtg.cube.model.support.ManaType;

public class BasicLand extends Land {

    public BasicLand(String name, ManaType manaType) {
        super(name, new ManaCost(new ManaQuantityTuple(1, manaType)));
    }

    public BasicLand(String name, ManaCost produces) {
        super(name, produces);
    }

    public BasicLand(BasicLand basicLand) {
        this(basicLand.getName(), new ManaCost(basicLand.getProduces()));
    }
}
