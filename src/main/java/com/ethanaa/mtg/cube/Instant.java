package com.ethanaa.mtg.cube;


import java.util.HashSet;
import java.util.Set;

public class Instant extends Card {

    public Instant(String name, ManaCost manaCost, Set<String> subTypes, String text, Expansion expansion, Rarity rarity) {

        super(name, manaCost, CardType.INSTANT, subTypes, text, expansion, rarity);
    }

    public Instant(String name, ManaCost manaCost, String text, Expansion expansion, Rarity rarity) {

        super(name, manaCost, CardType.INSTANT, null, text, expansion, rarity);
    }

    public Instant(Instant instant) {

        this(instant.getName(), new ManaCost(instant.getManaCost()),
                new HashSet<>(instant.getSubTypes()), instant.getText(),
                instant.getExpansion(), instant.getRarity());
    }
}
