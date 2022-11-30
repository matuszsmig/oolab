package agh.ics.oop.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class App extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        var gridPane = new GridPane();
        gridPane.add(new Label("test1"), 0, 0);
        gridPane.add(new Label("test2"), 1, 0);

        Scene scene = new Scene(gridPane, 400, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
