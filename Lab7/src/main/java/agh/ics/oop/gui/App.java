package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {

    Label label = new Label("Zwierzak");
    Scene scene = new Scene(label, 400, 400);
    GridPane grid = new GridPane();

    @Override
    public void init() throws InterruptedException {
        try {
            String[] args = getParameters().getRaw().toArray(new String[0]);
            MoveDirection[] directions = OptionsParser.parse(args);
            GrassField map = new GrassField(3);
            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void generateView() {
        grid.setGridLinesVisible(true);


    }
}
