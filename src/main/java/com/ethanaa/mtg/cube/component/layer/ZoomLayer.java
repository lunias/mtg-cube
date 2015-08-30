package com.ethanaa.mtg.cube.component.layer;


import com.ethanaa.mtg.cube.component.node.CardNode;
import com.ethanaa.mtg.cube.component.node.LandNode;
import com.ethanaa.mtg.cube.model.exception.CopyException;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import org.springframework.stereotype.Component;

@Component
public class ZoomLayer extends HBox {

    public ZoomLayer() {
        initLayer();
    }

    private void initLayer() {

        setVisible(false);
        setMouseTransparent(true);

        setAlignment(Pos.CENTER);

        getStyleClass().add("zoom-layer");
    }

    public void zoomIn(StackPane node, double magnification) {

        try {
            if (node instanceof CardNode) {
                node = new CardNode((CardNode) node);
            } else if (node instanceof LandNode) {
                node = new LandNode((LandNode) node);
            }
        } catch (CopyException ce) {
            return;
        }

        node.getStyleClass().add("drop-shadow");

        node.setMaxSize(230.0 * magnification, 330.0 * magnification);
        node.setPrefWidth(230.0 * magnification);

        getChildren().add(node);
        setVisible(true);
    }

    public void zoomOut() {

        getChildren().clear();
        setVisible(false);
    }

}
