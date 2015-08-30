package com.ethanaa.mtg.cube.model;


import com.ethanaa.mtg.cube.model.support.CardType;
import com.ethanaa.mtg.cube.model.support.Expansion;
import com.ethanaa.mtg.cube.model.support.ManaCost;
import com.ethanaa.mtg.cube.model.support.Rarity;

import java.util.HashSet;
import java.util.Set;

public class Sorcery extends Card {

    public Sorcery(String name, ManaCost manaCost, Set<String> subTypes, String text, Expansion expansion, Rarity rarity) {

        super(name, manaCost, CardType.SORCERY, subTypes, text, expansion, rarity);
    }

    public Sorcery(String name, ManaCost manaCost, String text, Expansion expansion, Rarity rarity) {

        super(name, manaCost, CardType.SORCERY, null, text, expansion, rarity);
    }

    public Sorcery(Sorcery sorcery) {

        this(sorcery.getName(), new ManaCost(sorcery.getManaCost()),
                new HashSet<>(sorcery.getSubTypes()), sorcery.getText(),
                sorcery.getExpansion(), sorcery.getRarity());
    }
}
