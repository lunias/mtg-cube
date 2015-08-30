package com.ethanaa.mtg.cube.service;

import com.ethanaa.mtg.cube.model.BasicLand;
import com.ethanaa.mtg.cube.model.Card;
import com.ethanaa.mtg.cube.model.Creature;
import com.ethanaa.mtg.cube.model.Sorcery;
import com.ethanaa.mtg.cube.model.support.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CardService {

    private Map<String, Card> cardMap = new HashMap<>();

    public CardService() {

        String name = "Mountain";
        cardMap.put(name, new BasicLand(name, ManaType.RED));

        name = "Plains";
        cardMap.put(name, new BasicLand(name, ManaType.WHITE));

        name = "Island";
        cardMap.put(name, new BasicLand(name, ManaType.BLUE));

        name = "Swamp";
        cardMap.put(name, new BasicLand(name, ManaType.BLACK));

        name = "Forest";
        cardMap.put(name, new BasicLand(name, ManaType.GREEN));

        name = "Accorder Paladin";
        cardMap.put(name, new Creature(name,
                new ManaCost(new ManaCostTuple(1, ManaType.COLORLESS),
                        new ManaCostTuple(1, ManaType.WHITE)),
                new HashSet<>(Arrays.asList("Human", "Knight")),
                "Battle cry (Whenever this creature attacks, each other " +
                        "attacking creature gets +1/+0 until end of turn.)",
                3, 1,
                Expansion.ALPHA, Rarity.UNCOMMON));

        name = "Aetherling";
        cardMap.put(name, new Creature(name,
                new ManaCost(new ManaCostTuple(4, ManaType.COLORLESS),
                        new ManaCostTuple(2, ManaType.BLUE)),
                new HashSet<>(Arrays.asList("Shapeshifter")),
                "{U}: Exile Ætherling. Return it to the battlefield under " +
                        "its owner's control at the beginning of the next end step.\n" +
                        "\n" +
                        "{U}: Ætherling can't be blocked this turn.\n" +
                        "\n" +
                        "{1}: Ætherling gets +1/-1 until end of turn.\n" +
                        "\n" +
                        "{1}: Ætherling gets -1/+1 until end of turn.",
                4, 5,
                Expansion.ALPHA, Rarity.RARE));

        name = "Armageddon";
        cardMap.put(name, new Sorcery(name,
                new ManaCost(new ManaCostTuple(3, ManaType.COLORLESS),
                        new ManaCostTuple(1, ManaType.WHITE)),
                new HashSet<>(),
                "Destroy all lands.",
                Expansion.ALPHA, Rarity.RARE));

        name = "Balance";
        cardMap.put(name, new Sorcery(name,
                new ManaCost(new ManaCostTuple(1, ManaType.COLORLESS),
                        new ManaCostTuple(1, ManaType.WHITE)),
                new HashSet<>(),
                "Each player chooses a number of lands he or she controls " +
                        "equal to the number of lands controlled by the player " +
                        "who controls the fewest, then sacrifices the rest. " +
                        "Players discard cards and sacrifice creatures the same way.",
                Expansion.ALPHA, Rarity.RARE));

        name = "Baneslayer Angel";
        cardMap.put(name, new Creature(name,
                new ManaCost(new ManaCostTuple(3, ManaType.COLORLESS),
                        new ManaCostTuple(2, ManaType.WHITE)),
                new HashSet<>(Arrays.asList("Angel")),
                "Flying, first strike, lifelink, protection from Demons and from Dragons",
                5, 5,
                Expansion.ALPHA, Rarity.MYTHIC_RARE));

        name = "Blade Splicer";
        cardMap.put(name, new Creature(name,
                new ManaCost(new ManaCostTuple(2, ManaType.COLORLESS),
                        new ManaCostTuple(1, ManaType.WHITE)),
                new HashSet<>(Arrays.asList("Human", "Artificer")),
                "When Blade Splicer enters the battlefield, put a 3/3 colorless Golem artifact " +
                        "creature token onto the battlefield.\n" +
                        "\n" +
                        "Golem creatures you control have first strike.",
                1, 1,
                Expansion.ALPHA, Rarity.RARE));

        name = "Brimaz, King of Oreskos";
        cardMap.put(name, new Creature(name,
                new ManaCost(new ManaCostTuple(1, ManaType.COLORLESS),
                        new ManaCostTuple(2, ManaType.WHITE)),
                new HashSet<>(Arrays.asList("Cat", "Soldier")),
                "Vigilance\n" +
                        "\n" +
                        "Whenever Brimaz, King of Oreskos attacks, put a 1/1 white Cat Soldier " +
                        "creature token with vigilance onto the battlefield attacking.\n" +
                        "\n" +
                        "Whenever Brimaz blocks a creature, put a 1/1 white Cat Soldier " +
                        "creature token with vigilance onto the battlefield blocking that creature.",
                3, 4,
                Expansion.ALPHA, Rarity.MYTHIC_RARE));

        cardMap = Collections.unmodifiableMap(cardMap);
    }

    public Card getCard(String name) {

        return cardMap.get(name);
    }

    public Collection<Card> getCards() {

        return cardMap.values();
    }

}
