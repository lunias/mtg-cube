package com.ethanaa.mtg.cube;


public class ManaCostTuple implements Comparable<ManaCostTuple> {

    private int quantity;

    private ManaType type;

    public ManaCostTuple(int quantity, ManaType type) {

        this.quantity = quantity;
        this.type = type;
    }

    public ManaCostTuple(ManaCostTuple manaCostTuple) {

        this(manaCostTuple.getQuantity(), manaCostTuple.getType());
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ManaType getType() {
        return type;
    }

    public void setType(ManaType type) {
        this.type = type;
    }

    @Override
    public int compareTo(ManaCostTuple o) {

        int typeComparion = this.getType().compareTo(o.getType());

        if (typeComparion == 0) {
            return this.getQuantity() > o.getQuantity() ? 1 : this.getQuantity() < o.getQuantity() ? -1 : 0;
        }

        return typeComparion;
    }

    @Override
    public String toString() {
        return "ManaCostTuple{" +
                "quantity=" + quantity +
                ", type=" + type +
                '}';
    }
}
