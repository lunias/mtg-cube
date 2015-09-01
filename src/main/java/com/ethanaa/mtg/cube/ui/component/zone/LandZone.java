package com.ethanaa.mtg.cube.ui.component.zone;

import com.ethanaa.mtg.cube.model.support.ManaQuantityTuple;
import com.ethanaa.mtg.cube.ui.component.Player;
import com.ethanaa.mtg.cube.ui.component.layer.ZoomLayer;
import com.ethanaa.mtg.cube.ui.node.LandNode;
import com.ethanaa.mtg.cube.ui.node.LandNodeStack;
import com.ethanaa.mtg.cube.model.Land;
import com.ethanaa.mtg.cube.service.CardService;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class LandZone extends GridPane {

    private Player player;

    private LibraryZone libraryZone;
    private ZoomLayer zoomLayer;

    private CardService cardService;

    @Autowired
    public LandZone(Player player, LibraryZone libraryZone, ZoomLayer zoomLayer, CardService cardService) {

        this.player = player;

        this.libraryZone = libraryZone;
        this.zoomLayer = zoomLayer;

        this.cardService = cardService;

        initZone();
    }

    private void initZone() {

        getStyleClass().add("landZone");
        setHgap(35.0);
        setPadding(new Insets(10.0, 10.0, 50.0, 0.0));
        setAlignment(Pos.CENTER);

        // land stacks
        for (int i = 0; i < 6; i++) {
            add(createLandNodeStack(), i, 0, 1, 1);
        }

        // deck
        add(libraryZone, 6, 0, 1, 1);

        // discard
        add(new LandNode((Land) cardService.getCard("Mountain")), 7, 0, 1, 1);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(12.5);
        col1.setHalignment(HPos.LEFT);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(12.5);
        col2.setHalignment(HPos.LEFT);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(12.5);
        col3.setHalignment(HPos.LEFT);
        ColumnConstraints col4 = new ColumnConstraints();
        col4.setPercentWidth(12.5);
        col4.setHalignment(HPos.LEFT);
        ColumnConstraints col5 = new ColumnConstraints();
        col5.setPercentWidth(12.5);
        col5.setHalignment(HPos.LEFT);
        ColumnConstraints col6 = new ColumnConstraints();
        col6.setPercentWidth(12.5);
        col6.setHalignment(HPos.LEFT);
        ColumnConstraints col7 = new ColumnConstraints();
        col7.setPercentWidth(12.5);
        col7.setHalignment(HPos.RIGHT);
        ColumnConstraints col8 = new ColumnConstraints();
        col7.setPercentWidth(12.5);
        col7.setHalignment(HPos.LEFT);

        getColumnConstraints().addAll(col1, col2, col3, col4, col5, col6, col7, col8);

        Map<Integer, ObservableList<Land>> landStackMap = player.getLandStackMap();
        for (Map.Entry<Integer, ObservableList<Land>> entry : landStackMap.entrySet()) {

            int column = entry.getKey();
            ObservableList<Land> landStack = entry.getValue();

            landStack.addListener((ListChangeListener.Change<? extends Land> l) -> {
                while(l.next()) {
                    if (l.wasPermutated()) {
                        // handle permutation

                    } else if (l.wasUpdated()) {
                        // update item

                    } else {
                        for (Land land : l.getRemoved()) {

                            for (Node landNodeStack : getChildren()) {

                                if (landNodeStack instanceof LandNodeStack
                                        && getColumnIndex(landNodeStack) == column) {

                                    ((LandNodeStack) landNodeStack).removeLandNode(new LandNode(land));
                                    break;
                                }
                            }
                        }
                        for (Land land : l.getAddedSubList()) {

                            for (Node landNodeStack : getChildren()) {

                                if (landNodeStack instanceof LandNodeStack
                                        && getColumnIndex(landNodeStack) == column) {

                                    ((LandNodeStack) landNodeStack).addLandNode(createLandNode(land));
                                    break;
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    private LandNodeStack createLandNodeStack() {

        LandNodeStack landNodeStack = new LandNodeStack();

        return landNodeStack;
    }

    private LandNode createLandNode(Land land) {

        LandNode node = new LandNode(land);

        node.setOnMouseClicked(me -> {
            if (me.getButton() != MouseButton.SECONDARY) {

                node.tap();

                List<ManaQuantityTuple> manaProduces =
                        node.getLand().getProduces().getManaCostsSorted();

                if (node.getLand().isTapped()) {
                    for (ManaQuantityTuple mct : manaProduces) {
                        player.addManaToPool(mct);
                    }
                } else {
                    for (ManaQuantityTuple mct : manaProduces) {
                        player.removeManaFromPool(mct);
                    }
                }
            }
        });

        node.setOnMousePressed(me -> {
            if (me.getButton() == MouseButton.SECONDARY) {
                zoomLayer.zoomIn(node, 2.0);
            }
        });

        node.setOnMouseReleased(me -> {
            zoomLayer.zoomOut();
        });

        return node;
    }

}
