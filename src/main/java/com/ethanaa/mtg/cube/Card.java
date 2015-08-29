package com.ethanaa.mtg.cube;

import java.util.HashSet;
import java.util.Set;

public abstract class Card implements Comparable<Card> {

    private final String name;

    private ManaCost manaCost;

    private CardType type;

    private Set<String> subTypes;

    private final String text;

    private Expansion expansion;

    private Rarity rarity;

    public Card(String name, ManaCost manaCost,
                CardType type, Set<String> subTypes,
                String text, Expansion expansion, Rarity rarity) {

        this.name = name;
        this.manaCost = manaCost;
        this.type = type;
        this.subTypes = subTypes;
        this.text = text;
        this.expansion = expansion;
        this.rarity = rarity;
    }

    public Card(Card card) {

        this(card.getName(), new ManaCost(card.getManaCost()),
                card.getType(), new HashSet<>(card.getSubTypes()),
                card.getText(), card.getExpansion(), card.getRarity());
    }

    public String getName() {
        return name;
    }

    public ManaCost getManaCost() {
        return manaCost;
    }

    public void setManaCost(ManaCost manaCost) {
        this.manaCost = manaCost;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public Set<String> getSubTypes() {

        if (subTypes == null) {
            subTypes = new HashSet<>();
        }

        return subTypes;
    }

    public void setSubTypes(Set<String> subTypes) {
        this.subTypes = subTypes;
    }

    public String getText() {
        return text;
    }

    public Expansion getExpansion() {
        return expansion;
    }

    public void setExpansion(Expansion expansion) {
        this.expansion = expansion;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public int getConvertedManaCost() {
        return manaCost.getConvertedManaCost();
    }

    @Override
    public int compareTo(Card o) {
        return manaCost.compareTo(o.getManaCost());
    }

    public static <C extends Card> C copy(C card) throws CopyException {

        Class<?> cardType = card.getClass();

        try {

            return (C) cardType.getConstructor(cardType).newInstance(card);

        } catch (ReflectiveOperationException roe) {

            throw new CopyException(cardType, card, roe);
        }
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", manaCost=" + manaCost +
                ", type=" + type +
                ", subTypes=" + subTypes +
                ", \n\ttext='" + text + '\'' +
                ", \n\texpansion=" + expansion +
                ", rarity=" + rarity +
                '}';
    }
}
