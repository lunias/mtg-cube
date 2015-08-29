package com.ethanaa.mtg.cube;

import java.util.*;

public class ManaCost implements Comparable<ManaCost> {

    private Map<ManaType, ManaCostTuple> manaCosts = new HashMap<>();

    public ManaCost(ManaCostTuple... manaCostTuples) {

        for (ManaCostTuple manaCostTuple : manaCostTuples) {
            manaCosts.put(manaCostTuple.getType(), manaCostTuple);
        }
    }

    public ManaCost(ManaCost manaCost) {

        for (ManaCostTuple manaCostTuple : manaCost.getManaCosts().values()) {
            manaCosts.put(manaCostTuple.getType(), new ManaCostTuple(manaCostTuple));
        }
    }

    public Map<ManaType, ManaCostTuple> getManaCosts() {
        return manaCosts;
    }

    public List<ManaCostTuple> getManaCostsSorted() {

        List<ManaCostTuple> manaCostTuples = new ArrayList<>(manaCosts.values());

        Collections.sort(manaCostTuples);

        return manaCostTuples;
    }

    public int getConvertedManaCost() {

        int sum = 0;
        for (ManaCostTuple manaCostTuple : manaCosts.values()) {
            sum += manaCostTuple.getQuantity();
        }

        return sum;
    }

    public void setManaCosts(Map<ManaType, ManaCostTuple> manaCosts) {
        this.manaCosts = manaCosts;
    }

    @Override
    public int compareTo(ManaCost o) {

        return getConvertedManaCost() > o.getConvertedManaCost() ? 1
                : getConvertedManaCost() == o.getConvertedManaCost() ? 0 : -1;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (ManaCostTuple manaCostTuple : getManaCostsSorted()) {
            sb.append("(" + manaCostTuple.getQuantity() + "" + manaCostTuple.getType() + ")");
        }

        return sb.toString();
    }
}
