package com.ethanaa.mtg.cube;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Card lightningBolt = new Instant("Lightning Bolt",
                new ManaCost(new ManaCostTuple(1, ManaType.RED)),
                "Lightning Bolt deals 3 damage to target creature or player",
                Expansion.BETA, Rarity.UNCOMMON);

        Card baneSlayerAngel = new Creature("Baneslayer Angel",
                new ManaCost(new ManaCostTuple(3, ManaType.COLORLESS), new ManaCostTuple(2, ManaType.WHITE)),
                new HashSet<>(Arrays.asList("Angel")),
                "Flying, first strike, protection from Demons and from Dragons",
                5, 5,
                Expansion.ALPHA, Rarity.LEGENDARY);


        Deck deck1 = new Deck(lightningBolt, baneSlayerAngel);
        Player player1 = new Player("Ethan", deck1);

        try {

            Deck deck2 = new Deck(new CardQuantityTuple(4, lightningBolt),
                                  new CardQuantityTuple(2, baneSlayerAngel)
            );

            System.out.println(deck2);
            System.out.println(deck2.size());

            System.out.println(deck2.peekTopN(5));

        } catch (DeckInitializationException die) {
            die.printStackTrace();
        }
    }

}
