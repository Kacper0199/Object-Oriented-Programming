package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap{
    public ArrayList<Animal> animals = new ArrayList<>(); // todo protected
    protected MapVisualizer visualizer = new MapVisualizer(this);
    public List<Grass> grassFields = new ArrayList<>(); // todo protected
    protected int lowerBoundX = 0;
    protected int lowerBoundY = 0;
    protected int upperBoundX;
    protected int upperBoundY;
    protected Vector2d boundaryMax;
    protected Vector2d boundaryMin;


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
    public boolean isOccupied(Vector2d position){
        return animals.stream().anyMatch(a -> a.getPosition().equals(position));
    }

    @Override
    public Object objectAt(Vector2d position){
        return animals.stream().filter(a -> a.getPosition().equals(position))
                .findFirst().orElse(null);
    }

    @Override
    public String toString(){
        return visualizer.draw(boundaryMin, boundaryMax);
    }
}
