package com.ethanaa.mtg.cube.model.support;

import java.util.*;

public class ManaCost implements Comparable<ManaCost> {

    private Map<ManaType, ManaQuantityTuple> manaCosts = new HashMap<>();

    public ManaCost(ManaQuantityTuple... manaCostTuples) {

        for (ManaQuantityTuple manaCostTuple : manaCostTuples) {
            manaCosts.put(manaCostTuple.getType(), manaCostTuple);
        }
    }

    public ManaCost(ManaCost manaCost) {

        for (ManaQuantityTuple manaCostTuple : manaCost.getManaCosts().values()) {
            manaCosts.put(manaCostTuple.getType(), new ManaQuantityTuple(manaCostTuple));
        }
    }

    public Map<ManaType, ManaQuantityTuple> getManaCosts() {
        return manaCosts;
    }

    public List<ManaQuantityTuple> getManaCostsSorted() {

        List<ManaQuantityTuple> manaCostTuples = new ArrayList<>(manaCosts.values());

        Collections.sort(manaCostTuples);

        return manaCostTuples;
    }

    public int getConvertedManaCost() {

        int sum = 0;
        for (ManaQuantityTuple manaCostTuple : manaCosts.values()) {
            sum += manaCostTuple.getQuantity();
        }

        return sum;
    }

    public void setManaCosts(Map<ManaType, ManaQuantityTuple> manaCosts) {
        this.manaCosts = manaCosts;
    }

    @Override
    public int compareTo(ManaCost o) {

        return getConvertedManaCost() > o.getConvertedManaCost() ? 1
                : getConvertedManaCost() == o.getConvertedManaCost() ? 0 : -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ManaCost manaCost = (ManaCost) o;

        return manaCosts.equals(manaCost.manaCosts);
    }

    @Override
    public int hashCode() {
        return manaCosts.hashCode();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (ManaQuantityTuple manaCostTuple : getManaCostsSorted()) {
            sb.append("(" + manaCostTuple.getQuantity() + "" + manaCostTuple.getType() + ")");
        }

        return sb.toString();
    }
}
