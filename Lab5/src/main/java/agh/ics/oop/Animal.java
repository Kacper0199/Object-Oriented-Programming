package agh.ics.oop;

public class Animal extends AbstractWorldMapElement{
    private MapDirection direction;
    private IWorldMap map;

    public Animal(IWorldMap map, Vector2d initialPosition){
        super(initialPosition);
        this.direction = MapDirection.NORTH;
        this.map = map;
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

//    public Vector2d getPosition() {
//        return position;
//    }

    @Override
    public String toString() {
        return direction.toString();
    }
}