package agh.ics.oop;

public class Animal {
    private MapDirection direction;
    private Vector2d position;
    private IWorldMap map;

    public Animal(){
        this.direction = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
    }

    public Animal(IWorldMap map){
        this();
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this(map);
        this.position = initialPosition;
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    private void positionCheck(boolean goForward) {
        Vector2d desiredPosition = goForward ? position.add(this.direction.toUnitVector())
                                             : position.subtract(this.direction.toUnitVector());

        if (map.canMoveTo(desiredPosition)) {
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

    public Vector2d getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return direction.toString();
    }
}