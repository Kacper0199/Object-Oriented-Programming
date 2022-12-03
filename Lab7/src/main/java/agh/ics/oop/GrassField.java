package agh.ics.oop;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap{
    private int grassNum;
    private MapBoundary mapBoundary;

    public GrassField(int grassNum) {
        this.grassNum = grassNum;
        this.boundaryMax = new Vector2d(generateUpperBound(grassNum),
                                        generateUpperBound(grassNum));
        this.boundaryMin = new Vector2d(0, 0);

        this.mapBoundary = new MapBoundary();
        initField();
    }

    public GrassField(int grassNum, int grassLowerBoundX, int grassLowerBoundY) {
        this(grassNum);
        this.boundaryMin = new Vector2d(grassLowerBoundX, grassLowerBoundY);
    }

    private int generateUpperBound(int grassNum) {
        int upperBound = (int) sqrt(grassNum * 10);
        this.upperBoundX = upperBound;
        this.upperBoundY = upperBound;
        return upperBound;
    }

    private int generateRandom(int start, int end) {
        return start + (int) (Math.random() * ((end - start) + 1));
    }

    private void addGrassField() {
        Vector2d newField = new Vector2d(generateRandom(lowerBoundX, upperBoundX),
                generateRandom(lowerBoundY, upperBoundY));

        if (!isOccupied(newField)) {
            grass.put(newField, new Grass(newField));
            mapBoundary.addObject(newField);
        }
    }

    private void initField() {
        while (grass.size() < grassNum) {
            addGrassField();
        }
    }

    private void newBoundView(Vector2d objectPosition){
        mapBoundary.addObject(objectPosition);
        Vector2d[] bounds = mapBoundary.getBounds();
        boundaryMax = bounds[1];
        boundaryMin = bounds[0];

//        boundaryMax = boundaryMax.upperRight(objectPosition);
//        boundaryMin = boundaryMin.lowerLeft(objectPosition);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        Object onObject = objectAt(position);

        boolean isValidPosition = position.precedes(new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE)) &&
                                  position.follows(new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE)) &&
                                  !(onObject instanceof Animal);


        if(onObject instanceof Grass && isValidPosition){
            addGrassField();
            grass.remove(position);
            mapBoundary.removeObject(position);
            return true;
        } else if (isValidPosition){
            newBoundView(position);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
