package agh.ics.oop;

import java.util.ArrayList;

public class Animal extends AbstractWorldMapElement{
    private final ArrayList<IPositionChangeObserver> observers;
    private MapDirection direction;
    private IWorldMap map;

    public Animal(IWorldMap map, Vector2d initialPosition){
        super(initialPosition);
        this.direction = MapDirection.NORTH;
        this.map = map;
        this.observers = new ArrayList<>();

        addObserver((IPositionChangeObserver) map);
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver observer : observers) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    private void positionCheck(boolean goForward) {
        Vector2d desiredPosition = goForward ? position.add(this.direction.toUnitVector())
                                             : position.subtract(this.direction.toUnitVector());

        if (map.canMoveTo(desiredPosition)) {
            positionChanged(position, desiredPosition);
            position = desiredPosition;
        }
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case FORWARD -> positionCheck(true);
            case BACKWARD -> positionCheck(false);
        }
    }

    public MapDirection getDirection() {
        return direction;
    }

    public void addObserver(IPositionChangeObserver newObserver) {
        this.observers.add(newObserver);
    }

    public void removeObserver(IPositionChangeObserver observerToRemove) {
        this.observers.remove(observerToRemove);
    }

    @Override
    public String toString() {
        return direction.toString();
    }
}