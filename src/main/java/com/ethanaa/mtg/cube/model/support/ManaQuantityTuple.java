package com.ethanaa.mtg.cube.model.support;


public class ManaQuantityTuple implements Comparable<ManaQuantityTuple> {

    private int quantity;

    private ManaType type;

    public ManaQuantityTuple(int quantity, ManaType type) {

        this.quantity = quantity;
        this.type = type;
    }

    public ManaQuantityTuple(ManaQuantityTuple manaCostTuple) {

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
    public int compareTo(ManaQuantityTuple o) {

        int typeComparion = this.getType().compareTo(o.getType());

        if (typeComparion == 0) {
            return this.getQuantity() > o.getQuantity() ? 1 : this.getQuantity() < o.getQuantity() ? -1 : 0;
        }

        return typeComparion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ManaQuantityTuple that = (ManaQuantityTuple) o;

        if (quantity != that.quantity) return false;
        return type == that.type;

    }

    @Override
    public int hashCode() {
        int result = quantity;
        result = 31 * result + type.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ManaCostTuple{" +
                "quantity=" + quantity +
                ", type=" + type +
                '}';
    }
}
