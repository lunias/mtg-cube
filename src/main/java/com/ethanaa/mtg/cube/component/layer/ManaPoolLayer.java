package com.ethanaa.mtg.cube.component.layer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.shape.Rectangle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ManaPoolLayer extends AnchorPane {

    public ManaPoolLayer() {
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
    }

    private HBox createManaPool() {

        HBox manaPool = new HBox();

        manaPool.getStyleClass().add("manaPool");
        manaPool.setPadding(new Insets(5.0));
        manaPool.setSpacing(5);
        manaPool.setAlignment(Pos.CENTER);

        HBox.setHgrow(manaPool, Priority.NEVER);

        List<Rectangle> manaTypeIndicators = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            manaTypeIndicators.add(new Rectangle(40.0, 40.0));
        }

        manaPool.getChildren().addAll(manaTypeIndicators);

        return new HBox(manaPool);
    }
}
