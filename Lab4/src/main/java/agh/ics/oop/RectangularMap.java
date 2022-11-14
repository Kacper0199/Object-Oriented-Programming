package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{
    private int lowerBoundX = 0;
    private int lowerBoundY = 0;
    private final Vector2d boundaryMax;
    private final Vector2d boundaryMin;
    public List<Animal> animals = new ArrayList<>();

    public RectangularMap(int width, int height){
        this.boundaryMax = new Vector2d(width, height);
        this.boundaryMin = new Vector2d(lowerBoundX, lowerBoundY);
    }

    public RectangularMap(int width, int height, int lowX, int lowY){
        this(width, height);
        this.lowerBoundX = lowX;
        this.lowerBoundY = lowY;
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        return position.precedes(boundaryMax) && position.follows(boundaryMin)
                && !this.isOccupied(position);
    }

    @Override
    public boolean place(Animal animal){
        if(this.canMoveTo(animal.getPosition())){
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.stream().anyMatch(a -> a.getPosition().equals(position));
    }

    @Override
    public Object objectAt(Vector2d position){
        return animals.stream().filter(a -> a.getPosition().equals(position))
                      .findFirst().orElse(null);
    }

    @Override
    public String toString(){
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(boundaryMin, boundaryMax);
    }
}
