package com.ethanaa.mtg.cube.ui.component.layer;

import com.ethanaa.mtg.cube.model.support.ManaType;
import com.ethanaa.mtg.cube.ui.component.Player;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.MapChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.converter.NumberStringConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ManaPoolLayer extends AnchorPane {

    private Player player;

    private Map<ManaType, SimpleIntegerProperty> manaTypeCounts;

    @Autowired
    public ManaPoolLayer(Player player) {

        this.player = player;

        manaTypeCounts = new HashMap<ManaType, SimpleIntegerProperty>() {
            {
                for (int i = 0; i < ManaType.values().length; i++) {
                    put(ManaType.values()[i], new SimpleIntegerProperty(0));
                }
            }
        };

        initLayer();
    }

    private void initLayer() {

        getStyleClass().add("manaPoolLayer");
        setPickOnBounds(false);

        HBox manaPool = createManaPool();
        getChildren().addAll(
                manaPool
        );

        AnchorPane.setBottomAnchor(manaPool, 0.0);
        AnchorPane.setRightAnchor(manaPool, 0.0);

        player.getManaTypeCounts().addListener((
                MapChangeListener.Change<? extends ManaType, ? extends Integer> c) -> {

            if (c.wasAdded()) {

                ManaType modifiedManaType = c.getKey();
                Integer modifiedManaQuantity = c.getValueAdded();

                SimpleIntegerProperty quantity = manaTypeCounts.get(modifiedManaType);
                quantity.set(modifiedManaQuantity);
            }
        });
    }

    private HBox createManaPool() {

        HBox manaPool = new HBox();

        manaPool.getStyleClass().add("manaPool");
        manaPool.setPadding(new Insets(5.0));
        manaPool.setSpacing(5);
        manaPool.setAlignment(Pos.CENTER);

        HBox.setHgrow(manaPool, Priority.NEVER);

        List<StackPane> manaTypeIndicators = new ArrayList<>();
        for (int i = 1; i < 6; i++) {

            ManaType manaType = ManaType.values()[i];

            StackPane stack = new StackPane();

            Label quantityLabel = new Label("0");
            quantityLabel.getStyleClass().add("manaQuantityLabel");

            quantityLabel.textProperty().bindBidirectional(
                    manaTypeCounts.get(manaType), new NumberStringConverter());

            Rectangle typeRectangle = new Rectangle(40.0, 40.0);
            typeRectangle.setFill(Color.web(manaType.getHexColor()));

            stack.getChildren().addAll(typeRectangle, quantityLabel);

            manaTypeIndicators.add(stack);
        }

        manaPool.getChildren().addAll(manaTypeIndicators);

        return new HBox(manaPool);
    }
}
