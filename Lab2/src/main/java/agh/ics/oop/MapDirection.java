package agh.ics.oop;

public enum MapDirection {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    final private static MapDirection[] directVals = values();

    public String toString() {
        return switch (this) {
            case NORTH -> "Polnoc";
            case EAST -> "Wschod";
            case SOUTH -> "Poludnie";
            case WEST -> "Zachod";
        };
    }

    public MapDirection next() {
        return directVals[(this.ordinal()+1) % directVals.length];
    }

    public MapDirection previous() {
        return directVals[(this.ordinal()-1 + directVals.length) % directVals.length];
    }

    public Vector2d toUnitVector() {
        return switch (this) {
            case NORTH -> new Vector2d(0, 1);
            case EAST -> new Vector2d(1, 0);
            case SOUTH -> new Vector2d(0, -1);
            case WEST -> new Vector2d(-1, 0);
        };
    }
}
