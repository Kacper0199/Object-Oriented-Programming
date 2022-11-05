package agh.ics.oop;


public class Animal {
    private static final int upperBound = 4;
    private static final int lowerBound = 0;
    private static final Vector2d boundaryMax = new Vector2d(upperBound, upperBound);
    private static final Vector2d boundaryMin = new Vector2d(lowerBound, lowerBound);

    private MapDirection direction;
    private Vector2d position;

    public Animal(){
        this.direction = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    private static boolean positionCheck(Vector2d position) {
        return position.precedes(boundaryMax) && position.follows(boundaryMin);
    }

    public void move(MoveDirection move) {
        switch (move) {
            case RIGHT -> direction = direction.next();
            case LEFT -> direction = direction.previous();
            case FORWARD -> {
                Vector2d desiredPosition = position.add(direction.toUnitVector());
                if (positionCheck(desiredPosition)) {position = desiredPosition;}
            }
            case BACKWARD -> {
                Vector2d desiredPosition = position.subtract(direction.toUnitVector());
                if (positionCheck(desiredPosition)) {position = desiredPosition;}
            }
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
        return "position: " + position.toString() + "\n" +
                "direction: " + direction.toString();
    }
}
