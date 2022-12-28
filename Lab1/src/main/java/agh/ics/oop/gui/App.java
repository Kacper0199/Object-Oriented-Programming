package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;


public class App extends Application {
    private GridPane grid = new GridPane();
    private AbstractWorldMap map;
    private int width = 40;
    private int height = 40;
    private int sceneWidth = 600;
    private int sceneHeight = 600;
    private Vector2d boundMax;
    private Vector2d boundMin;
    private int moveDelay = 200;
    private Font objectFont = Font.font("Verdana", FontWeight.BOLD, 20);
    private Font font = Font.font("Verdana", FontPosture.ITALIC, 12);
    private Button button;
    private TextField textField;
    private SimulationEngine engine;
    private Stage stage;

    @Override
    public void init() {

        try {
            button = new Button("Start");
            textField = new TextField();
            String[] args = getParameters().getRaw().toArray(new String[0]);
            MoveDirection[] directions = OptionsParser.parse(args);
            map = new GrassField(6);
            Vector2d[] positions = { new Vector2d(2, 2), new Vector2d(3, 4) };
            engine = new SimulationEngine(directions, map, positions, moveDelay, this);
//            threadEngine = new Thread(engine::run);
//            engine.run();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {

        init();
        this.stage = primaryStage;


        HBox input = new HBox(button, textField);
        VBox verticalBox = new VBox(grid, input);
        verticalBox.setAlignment(Pos.CENTER);
        input.setAlignment(Pos.CENTER);


        button.setOnAction(event -> {
            List<MoveDirection> directions = List.of(OptionsParser.parse(textField.getText().split(" ")));
            engine.setDirections(directions);
            Thread thread = new Thread(engine);
            thread.start();
        });

        generateView();

        Scene scene = new Scene(verticalBox, sceneWidth, sceneHeight);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void generateView() throws FileNotFoundException{
        grid.setGridLinesVisible(false);
        grid.getChildren().clear();
        grid.getRowConstraints().clear();
        grid.getColumnConstraints().clear();
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

        stage.show();
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
            VBox element = new GuiElementBox(obj).getvBox();
            int[] position = gridPosition(obj.getPosition());
            grid.add(element, position[0], position[1]);
            GridPane.setHalignment(element, HPos.CENTER);
        }
    }

//    public void refreshGrid() throws FileNotFoundException {
//        grid.getChildren().clear();
//        grid.setGridLinesVisible(false);
//        grid.getRowConstraints().clear();
//        grid.getColumnConstraints().clear();
//        generateView();
//    }

    public void refreshGrid() {
        Platform.runLater(() -> {
            try {
                generateView();
            } catch (FileNotFoundException exception) {
                System.out.println(exception.getMessage());
            }
        });
    }
}
