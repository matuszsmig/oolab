package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;


public class App extends Application{
    private AbstractWorldMap map;

    public void init(){

        String[] args = getParameters().getRaw().toArray(new String[0]);

        try{
            MoveDirection[] directions = new OptionsParser().parse(args);
            map = new GrassField(10);
            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
    public void start(Stage stage){
        int xMin = map.findLeftBottomCorner().getX();
        int yMin = map.findLeftBottomCorner().getY();
        int xMax = map.findRightTopCorner().getX();
        int yMax = map.findRightTopCorner().getY();

        int width = 20;
        int height = 20;

        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);

        gridPane.getColumnConstraints().add(new ColumnConstraints(width));
        gridPane.getRowConstraints().add(new RowConstraints(height));

        Label start = new Label("y/x");
        gridPane.add(start,0,0);
        GridPane.setHalignment(start, HPos.CENTER);

        int index=1;
        for(int i=xMin;i<=xMax;i++){
            gridPane.getColumnConstraints().add(new ColumnConstraints(width));
            Label label = new Label(Integer.toString(i));
            gridPane.add(label,index,0);
            GridPane.setHalignment(label,HPos.CENTER);
            index+=1;
        }
        index=1;
        for(int j=yMin;j<=yMax;j++){
            gridPane.getRowConstraints().add(new RowConstraints(height));
            Label label = new Label(Integer.toString(yMax-j));
            gridPane.add(label,0,index);
            GridPane.setHalignment(label,HPos.CENTER);
            index+=1;
        }
        for(int j=yMin;j<=yMax;j++){
            for(int i=xMin;i<=xMax;i++){
                Vector2d pos = new Vector2d(i,j);
                if(map.isOccupied(pos)){
                    Label label = new Label(map.objectAt(pos).toString());
                    gridPane.add(label,i+1,yMax-j+1);
                    GridPane.setHalignment(label,HPos.CENTER);
                }
                else {
                    gridPane.add(new Label(" "),i+1,yMax-j+1);
                }
            }
        }
        Scene scene = new Scene(gridPane, 400, 400);
        stage.setScene(scene);
        stage.show();
    }
}
