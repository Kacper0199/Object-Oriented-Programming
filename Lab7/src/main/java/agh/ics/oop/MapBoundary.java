package agh.ics.oop;

import java.util.Comparator;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {
    private TreeSet<Vector2d> xAxis = new TreeSet<>(Comparator.comparingInt(vect -> vect.x));
    private TreeSet<Vector2d> yAxis = new TreeSet<>(Comparator.comparingInt(vect -> vect.y));

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        removeObject(oldPosition);
        addObject(newPosition);
    }

    public void removeObject(Vector2d obj){
        xAxis.remove(obj);
        yAxis.remove(obj);
    }

    public void addObject(Vector2d obj){
        xAxis.add(obj);
        yAxis.add(obj);
    }

    public Vector2d[] getBounds(){
        return new Vector2d[]{new Vector2d(xAxis.first().x, yAxis.first().y),
                              new Vector2d(xAxis.last().x, yAxis.last().y)};
    }
}
