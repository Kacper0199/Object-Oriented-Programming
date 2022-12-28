package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap{

    public RectangularMap(int width, int height){
        this.upperBoundX = width-1;
        this.upperBoundY = height-1;
        this.boundaryMax = new Vector2d(upperBoundX, upperBoundY);
        this.boundaryMin = new Vector2d(lowerBoundX, lowerBoundY);
    }

    public RectangularMap(int width, int height, int lowX, int lowY){
        this(width, height);
        this.lowerBoundX = lowX;
        this.lowerBoundY = lowY;
    }
}
