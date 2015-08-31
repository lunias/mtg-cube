package com.ethanaa.mtg.cube.ui.node;

import com.ethanaa.mtg.cube.model.Card;
import com.ethanaa.mtg.cube.model.exception.CopyException;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class CardNode extends StackPane {

    protected Card card;

    protected SimpleBooleanProperty showRedCircle;
    protected SimpleBooleanProperty showGreenCircle;
    protected SimpleBooleanProperty showBlueCircle;

    public CardNode(Card card) {

        this.card = card;

        this.showRedCircle = new SimpleBooleanProperty(true);
        this.showGreenCircle = new SimpleBooleanProperty(true);
        this.showBlueCircle = new SimpleBooleanProperty(true);

        initNode();
    }

    public CardNode(CardNode cardNode) throws CopyException {

        this(Card.copy(cardNode.getCard()));
    }

    private void initNode() {

        String css = "-fx-background-image: url(\"cards/" + card.getUrlName() + ".jpg\");" +
                "-fx-background-size: cover;";
        setStyle(css);

        setMinSize(156.0, 222.5);

        getChildren().addAll(
                createEffectsOverlay()
        );
    }

    private AnchorPane createEffectsOverlay() {

        AnchorPane effectsOverlay = new AnchorPane();
        effectsOverlay.setPadding(new Insets(5.0));
        effectsOverlay.setMouseTransparent(true);

        VBox infoPanel = new VBox(12.5);
        AnchorPane.setTopAnchor(infoPanel, 20.0);
        AnchorPane.setRightAnchor(infoPanel, 0.0);

        Circle redCircle = new Circle(12.5, Color.RED);
        redCircle.visibleProperty().bindBidirectional(showRedCircle);

        Circle greenCircle = new Circle(12.5, Color.GREEN);
        greenCircle.visibleProperty().bindBidirectional(showGreenCircle);

        Circle blueCircle = new Circle(12.5, Color.BLUE);
        blueCircle.visibleProperty().bindBidirectional(showBlueCircle);

        infoPanel.getChildren().addAll(redCircle, greenCircle, blueCircle);

        effectsOverlay.getChildren().addAll(infoPanel);

        return effectsOverlay;
    }

    public Card getCard() {
        return card;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardNode cardNode = (CardNode) o;

        return card.equals(cardNode.card);
    }

    public int hashCode() {
        return card.hashCode();
    }
}
