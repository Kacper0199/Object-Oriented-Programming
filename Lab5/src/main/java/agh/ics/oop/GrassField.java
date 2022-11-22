package agh.ics.oop;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap{
    private int grassNum;

    public GrassField(int grassNum) {
        this.grassNum = grassNum;
        this.boundaryMax = new Vector2d(generateUpperBound(grassNum),
                                        generateUpperBound(grassNum));
        this.boundaryMin = new Vector2d(0, 0);
        initField();
    }

    public GrassField(int grassNum, int grassLowerBoundX, int grassLowerBoundY) {
        this(grassNum);
        this.boundaryMin = new Vector2d(grassLowerBoundX, grassLowerBoundY);
    }

    public int generateUpperBound(int grassNum) {
        int upperBound = (int) sqrt(grassNum * 10);
        this.upperBoundX = upperBound;
        this.upperBoundY = upperBound;
        return upperBound;
    }

    public int generateRandom(int start, int end) {
        return start + (int) (Math.random() * ((end - start) + 1));
    }

    public void addGrassField() {
        Vector2d newField = new Vector2d(generateRandom(lowerBoundX, upperBoundX),
                generateRandom(lowerBoundY, upperBoundY));
        if (!isOccupied(newField)) {
            grassFields.add(new Grass(newField));
        }
    }

    public void initField() {
        while (grassFields.size() < grassNum) {
            addGrassField();
        }
    }

    public void newBoundView(Vector2d objectPosition){
        boundaryMax = boundaryMax.upperRight(objectPosition);
        boundaryMin = boundaryMin.lowerLeft(objectPosition);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        Object onObject = objectAt(position);

        boolean isValidPosition = position.precedes(new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE)) &&
                                  position.follows(new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE)) &&
                                  !(onObject instanceof Animal);


        if(onObject instanceof Grass && isValidPosition){
            addGrassField();
            grassFields.remove(onObject);
            return true;
        } else if (isValidPosition){
            newBoundView(position);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if(super.isOccupied(position)){
            return super.isOccupied(position);
        }
        return grassFields.stream().anyMatch(a -> a.getPosition().equals(position));
    }

    @Override
    public Object objectAt(Vector2d position){
        if(super.objectAt(position) != null){
            return super.objectAt(position);
        }
        return grassFields.stream().filter(a -> a.getPosition().equals(position))
                .findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
