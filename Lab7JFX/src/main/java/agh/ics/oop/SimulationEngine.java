package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimulationEngine implements IEngine{
    private List<MoveDirection> directions;
    public List<Animal> animals = new ArrayList<>();
    private IWorldMap map;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] initialCoords){
        this.directions = new ArrayList<>(Arrays.asList(directions));
        this.map = map;

        for(Vector2d cord : initialCoords){
            Animal animal = new Animal(map, cord);
            animals.add(animal);
            map.place(animal);
        }
    }

    @Override
    public void run() {
        System.out.print(map);
        for(int i = 0; i < directions.size(); i++){
            animals.get(i%animals.size()).move(directions.get(i));
            System.out.print(map);
        }
    }
}
