package com.ethanaa.mtg.cube.model.support;

public enum ManaType {

    COLORLESS("C"), RED("R"), GREEN("G"), BLUE("U"), WHITE("W"), BLACK("B");

    private String abbreviation;

    ManaType(String abbreviation) {

        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Override
    public String toString() {
        return abbreviation;
    }
}
