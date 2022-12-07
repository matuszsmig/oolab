package agh.ics.oop.gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {
    Image image = new Image(new FileInputStream("src/main/resources/up.png"));
    ImageView imageView = new ImageView(image);

    public GuiElementBox() throws FileNotFoundException {
    }
    //imageView.setFitWidth(20);
    //imageView.setFitHeight(203);
}
