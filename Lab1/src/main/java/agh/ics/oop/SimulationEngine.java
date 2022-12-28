package agh.ics.oop;

import agh.ics.oop.gui.App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimulationEngine implements IEngine, Runnable{
    private List<MoveDirection> directions;
    public List<Animal> animals = new ArrayList<>();
    private IWorldMap map;
    private int moveDelay;
    private App app;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] initialCoords, int moveDelay, App app){
        this.directions = new ArrayList<>(Arrays.asList(directions));
        this.map = map;
        this.moveDelay = moveDelay;
        this.app = app;

        for(Vector2d cord : initialCoords){
            Animal animal = new Animal(map, cord);
            animals.add(animal);
            map.place(animal);
        }
    }

    public void setDirections(List<MoveDirection> newDirections) {
        directions = newDirections;
    }

    @Override
    public void run(){
//        System.out.print(map);

        for(int i = 0; i < directions.size(); i++){
            try {
                Thread.sleep(moveDelay);
            } catch (InterruptedException exception) {
                System.out.println(exception.getMessage());
            }
            animals.get(i%animals.size()).move(directions.get(i));
//            System.out.print(map);
            app.refreshGrid();

        }
    }
}
