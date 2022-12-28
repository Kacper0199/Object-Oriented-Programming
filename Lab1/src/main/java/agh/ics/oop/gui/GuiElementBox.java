package agh.ics.oop.gui;

import agh.ics.oop.Animal;
import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {
    public VBox vBox = new VBox();
    public Label label;
    public Image image;
    public ImageView imageView;
    IMapElement element;

    public GuiElementBox(IMapElement element){
        try {
            String path = element.getPath();
            image = new Image(new FileInputStream(path));
            makeElement(image, element);
        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void makeElement(Image image, IMapElement element) {
        imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        label = (element instanceof Animal) ? new Label(element.getPosition().toString()) : new Label("grass");

        vBox.getChildren().addAll(imageView, label);
        vBox.setAlignment(Pos.CENTER);
    }

    public VBox getvBox() {
        return vBox;
    }
}
