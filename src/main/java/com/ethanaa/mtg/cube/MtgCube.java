package com.ethanaa.mtg.cube;


import com.ethanaa.mtg.cube.ui.component.Table;
import javafx.application.Preloader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MtgCube extends JavaFxApplicationSupport {

    @Value("${app.ui.title:MTG Cube}")
    private String windowTitle;

    @Autowired
    private Table table;

    @Override
    public void start(Stage primaryStage) throws Exception {

        notifyPreloader(new Preloader.StateChangeNotification(Preloader.StateChangeNotification.Type.BEFORE_START));

        primaryStage.setTitle(windowTitle);

        Scene tableScene = new Scene(table);
        tableScene.getStylesheets().add("css/mtgcube.css");

        primaryStage.setScene(tableScene);
        primaryStage.setResizable(true);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launchApp(MtgCube.class, args);
    }
}
