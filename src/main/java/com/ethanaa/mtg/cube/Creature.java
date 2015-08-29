package com.ethanaa.mtg.cube;


import java.util.HashSet;
import java.util.Set;

public class Creature extends Card {

    private int power = 0;
    private int toughness = 0;

    public Creature(String name, ManaCost manaCost,
                    Set<String> subTypes, String text,
                    int power, int toughness, Expansion expansion, Rarity rarity) {

        super(name, manaCost, CardType.CREATURE, subTypes, text, expansion, rarity);

        this.power = power;
        this.toughness = toughness;
    }

    public Creature(Creature creature) {

        this(creature.getName(), new ManaCost(creature.getManaCost()),
                new HashSet<>(creature.getSubTypes()), creature.getText(),
                creature.getPower(), creature.getToughness(),
                creature.getExpansion(), creature.getRarity());
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getToughness() {
        return toughness;
    }

    public void setToughness(int toughness) {
        this.toughness = toughness;
    }

    @Override
    public String toString() {

        return super.toString() +
                "\n\t+ Creature{" +
                "power=" + power +
                ", toughness=" + toughness +
                '}';
    }
}
