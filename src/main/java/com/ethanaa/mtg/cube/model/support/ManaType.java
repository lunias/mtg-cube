package com.ethanaa.mtg.cube.model.support;

public enum ManaType {

    COLORLESS("C", "#bcbfb6"), RED("R", "#faaa8f"), GREEN("G", "#9bd3ae"), BLUE("U", "#aae0fa"), WHITE("W", "#fffcd6"), BLACK("B", "#ccc2c0");

    private String abbreviation;
    private String hexColor;

    ManaType(String abbreviation, String hexColor) {

        this.abbreviation = abbreviation;
        this.hexColor = hexColor;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getHexColor() {
        return hexColor;
    }

    public void setHexColor(String hexColor) {
        this.hexColor = hexColor;
    }

    @Override
    public String toString() {
        return abbreviation;
    }
}
