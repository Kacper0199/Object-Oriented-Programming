package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    protected Map<Vector2d, Animal> animals = new HashMap<>();
    protected Map<Vector2d, Grass> grass = new HashMap<>();
    protected MapVisualizer visualizer = new MapVisualizer(this);
    protected int lowerBoundX = 0;
    protected int lowerBoundY = 0;
    protected int upperBoundX;
    protected int upperBoundY;
    protected Vector2d boundaryMax;
    protected Vector2d boundaryMin;


    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = animals.get(oldPosition);
        animals.remove(oldPosition, animal);
        animals.put(newPosition, animal);
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        return position.precedes(boundaryMax) && position.follows(boundaryMin)
                && !this.isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) throws IllegalArgumentException {
        Vector2d animalPosition = animal.getPosition();
        if(this.canMoveTo(animalPosition)){
            animals.put(animalPosition, animal);
            return true;
        }
        throw new IllegalArgumentException(animalPosition + " is not legal position.");
    }

    @Override
    public boolean isOccupied(Vector2d position){
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position){
        if (animals.containsKey(position)) {
            return animals.get(position);
        } else return grass.getOrDefault(position, null);
    }

    @Override
    public String toString(){
        return visualizer.draw(boundaryMin, boundaryMax);
    }
}
