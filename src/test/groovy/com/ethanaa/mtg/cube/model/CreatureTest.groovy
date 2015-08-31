package com.ethanaa.mtg.cube.model

import com.ethanaa.mtg.cube.model.support.CardType
import com.ethanaa.mtg.cube.model.support.Expansion
import com.ethanaa.mtg.cube.model.support.ManaCost
import com.ethanaa.mtg.cube.model.support.ManaQuantityTuple
import com.ethanaa.mtg.cube.model.support.ManaType
import com.ethanaa.mtg.cube.model.support.Rarity
import spock.lang.Specification

class CreatureTest extends Specification {

    final static String DEFAULT_NAME = "Disenchant"
    final static ManaCost DEFAULT_MANA_COST = new ManaCost(new ManaQuantityTuple(1, ManaType.COLORLESS))
    final static CardType DEFAULT_CARD_TYPE = CardType.ARTIFACT
    final static Set<String> DEFAULT_SUB_TYPES = new HashSet<>()
    final static String DEFAULT_TEXT = "test"
    final static Expansion DEFAULT_EXPANSION = Expansion.ALPHA
    final static Rarity DEFAULT_RARITY = Rarity.COMMON

    final static int DEFAULT_POWER = 1
    final static int DEFAULT_TOUGHNESS = 1

    def "creature constructor works" () {

        when: "a creature card is created with the constructor"

        Card card = new Creature(DEFAULT_NAME, DEFAULT_MANA_COST,
                DEFAULT_SUB_TYPES, DEFAULT_TEXT,
                DEFAULT_POWER, DEFAULT_TOUGHNESS,
                DEFAULT_EXPANSION, DEFAULT_RARITY);

        then: "an initialized creature card is returned"

        card.getName() == DEFAULT_NAME
        card.getManaCost() == DEFAULT_MANA_COST
        card.getSubTypes() == DEFAULT_SUB_TYPES
        card.getText() == DEFAULT_TEXT
        card.getExpansion() == DEFAULT_EXPANSION
        card.getRarity() == DEFAULT_RARITY

        card.getType() == CardType.CREATURE
        card.getPower() == DEFAULT_POWER
        card.getToughness() == DEFAULT_TOUGHNESS
    }

    def "creature copy constructor works" () {

        given: "a creature card"

        Creature existingCard = new Creature(DEFAULT_NAME, DEFAULT_MANA_COST,
                DEFAULT_SUB_TYPES, DEFAULT_TEXT,
                DEFAULT_POWER, DEFAULT_TOUGHNESS,
                DEFAULT_EXPANSION, DEFAULT_RARITY);

        when: "a creature card is created with the copy constructor"

        Creature copiedCard = new Creature(existingCard)

        then: "the copied card is initialized properly"

        copiedCard.getName() == existingCard.getName()
        copiedCard.getName().is(existingCard.getName())

        copiedCard.getManaCost() == existingCard.getManaCost()
        !copiedCard.getManaCost().is(existingCard.getManaCost())

        copiedCard.getSubTypes() == existingCard.getSubTypes()
        !copiedCard.getSubTypes().is(existingCard.getSubTypes())

        copiedCard.getText() == existingCard.getText()
        copiedCard.getText().is(existingCard.getText())

        copiedCard.getPower() == existingCard.getPower()
        copiedCard.getToughness() == existingCard.getToughness()
        copiedCard.getExpansion() == existingCard.getExpansion()
        copiedCard.getRarity() == existingCard.getRarity()
    }

    def "creature comparison orders by mana cost" () {

        given: "4 shuffled creature cards with differing mana costs"

        Creature lowCard = new Creature(DEFAULT_NAME, new ManaCost(
                new ManaQuantityTuple(0, ManaType.COLORLESS)),
                DEFAULT_SUB_TYPES, DEFAULT_TEXT,
                DEFAULT_POWER, DEFAULT_TOUGHNESS,
                DEFAULT_EXPANSION, DEFAULT_RARITY);

        Creature mediumCard = new Creature(DEFAULT_NAME, DEFAULT_MANA_COST,
                DEFAULT_SUB_TYPES, DEFAULT_TEXT,
                DEFAULT_POWER, DEFAULT_TOUGHNESS,
                DEFAULT_EXPANSION, DEFAULT_RARITY);

        Creature sameMediumCard = new Creature(DEFAULT_NAME, DEFAULT_MANA_COST,
                DEFAULT_SUB_TYPES, DEFAULT_TEXT,
                DEFAULT_POWER, DEFAULT_TOUGHNESS,
                DEFAULT_EXPANSION, DEFAULT_RARITY);

        Creature highCard = new Creature(DEFAULT_NAME, new ManaCost(
                new ManaQuantityTuple(3, ManaType.COLORLESS),
                new ManaQuantityTuple(2, ManaType.RED)),
                DEFAULT_SUB_TYPES, DEFAULT_TEXT,
                DEFAULT_POWER, DEFAULT_TOUGHNESS,
                DEFAULT_EXPANSION, DEFAULT_RARITY);

        List<Card> cards = Arrays.asList(lowCard, mediumCard, sameMediumCard, highCard)

        Collections.shuffle(cards)

        when: "the shuffled creature cards are sorted"

        Collections.sort(cards);

        then: "the creature cards are ordered by mana cost"

        int lastManaCost = -1;
        for (Card card : cards) {
            card.getConvertedManaCost() >= lastManaCost
            lastManaCost = card.getConvertedManaCost()
        }
    }

}
