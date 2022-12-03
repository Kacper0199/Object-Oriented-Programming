package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.Map;


public class App extends Application {
    private GridPane grid = new GridPane();
    private AbstractWorldMap map;
    private int width = 40;
    private int height = 40;
    private int sceneWidth = 700;
    private int sceneHeight = 700;
    private Vector2d boundMax;
    private Vector2d boundMin;
    private Font objectFont = Font.font("Verdana", FontWeight.BOLD, 20);
    private Font font = Font.font("Verdana", FontPosture.ITALIC, 12);

    @Override
    public void init() throws InterruptedException {
        try {
            String[] args = getParameters().getRaw().toArray(new String[0]);
            MoveDirection[] directions = OptionsParser.parse(args);
            map = new GrassField(6);
            Vector2d[] positions = { new Vector2d(2, 2), new Vector2d(3, 4) };
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void start(Stage primaryStage){
        generateView();
        Scene scene = new Scene(grid, sceneWidth, sceneHeight);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void generateView() {
        grid.setGridLinesVisible(true);
        grid.setPadding(new Insets(30, 30, 30, 30));
        grid.setAlignment(Pos.CENTER);

        Map<Vector2d, AbstractWorldMapElement> animals = map.getAnimals();
        Map<Vector2d, AbstractWorldMapElement> grass = map.getGrass();
        boundMax = map.getBoundaryMax();
        boundMin = map.getBoundaryMin();

        addXYLabel();
        addHorizontalNumbers();
        addVerticalNumbers();
        addObjectsToGrid(animals);
        addObjectsToGrid(grass);
    }

    private void addConstraints(boolean x, int width, boolean y, int height){
        if (x) grid.getRowConstraints().add(new RowConstraints(height));
        if (y) grid.getColumnConstraints().add(new ColumnConstraints(width));
    }

    private void addXYLabel(){
        Label label = new Label("Y/X");
        label.setFont(font);
        grid.add(label, 0, 0);
        addConstraints(true, width, true, height);
        GridPane.setHalignment(label, HPos.CENTER);
    }

    private void addHorizontalNumbers(){
        for (int i = boundMin.x; i <= boundMax.x; i++) {
            Label iLabel = new Label(String.valueOf(i));
            iLabel.setFont(font);
            grid.add(iLabel, i - boundMin.x + 1, 0);
            addConstraints(false, width, true, height);
            GridPane.setHalignment(iLabel, HPos.CENTER);
        }
    }

    private void addVerticalNumbers(){
        for (int i = boundMin.y; i <= boundMax.y; i++) {
            Label iLabel = new Label(String.valueOf(i));
            iLabel.setFont(font);
            grid.add(iLabel, 0, boundMax.y - i + 1);
            addConstraints(true, width, false, height);
            GridPane.setHalignment(iLabel, HPos.CENTER);
        }
    }

    private int[] gridPosition(Vector2d position){
        return new int[]{position.x-boundMin.x+1, boundMax.y-position.y+1};
    }

    private void addObjectsToGrid(Map<Vector2d, AbstractWorldMapElement> objectsMap){
        for (AbstractWorldMapElement obj : objectsMap.values()) {
            Label objLabel = new Label(obj.toString());
            objLabel.setFont(objectFont);
            int[] position = gridPosition(obj.getPosition());
            grid.add(objLabel, position[0], position[1]);
            GridPane.setHalignment(objLabel, HPos.CENTER);
        }
    }
}
