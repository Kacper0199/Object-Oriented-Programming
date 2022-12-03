package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest{

    @Test
    public void canMoveToTest(){
        // given
        GrassField map = new GrassField(10);
        Animal animal = new Animal(map, new Vector2d(0, 0));
        Grass grass1 = new Grass(new Vector2d(2, 2));
        Grass grass2 = new Grass(new Vector2d(0, 0));

        // when
        map.place(animal);
        map.grass.put(new Vector2d(2, 2), grass1);
        map.grass.put(new Vector2d(0, 0), grass2);

        // then
        assertTrue(map.canMoveTo(new Vector2d(3, 0)));
        assertTrue(map.canMoveTo(new Vector2d(-100, -100)));
        assertTrue(map.canMoveTo(new Vector2d(100, 100)));
        assertTrue(map.canMoveTo(new Vector2d(2, 2)));
        assertFalse(map.canMoveTo(new Vector2d(0, 0)));
        assertTrue(map.canMoveTo(new Vector2d(map.upperBoundX+10, map.upperBoundY+10)));
        assertTrue(map.canMoveTo(new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE)));
        assertTrue(map.canMoveTo(new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE)));
    }

    @Test
    public void isOccupiedTest(){
        // given
        GrassField map = new GrassField(0);
        Animal animal1 = new Animal(map, new Vector2d(0, 0));
        Animal animal2 = new Animal(map, new Vector2d(-5, -10));
        Animal animal3 = new Animal(map, new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE));
        Animal animal4 = new Animal(map, new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE));
        Grass grass1 = new Grass(new Vector2d(2, 2));
        Grass grass2 = new Grass(new Vector2d(0, 0));


        // when
        map.place(animal1);
        map.place(animal2);
        map.place(animal3);
        map.place(animal4);
        map.grass.put(new Vector2d(2, 2), grass1);
        map.grass.put(new Vector2d(0, 0), grass2);

        // then
        assertTrue(map.isOccupied(animal1.getPosition()));
        assertTrue(map.isOccupied(animal2.getPosition()));
        assertTrue(map.isOccupied(animal3.getPosition()));
        assertTrue(map.isOccupied(animal4.getPosition()));
        assertFalse(map.isOccupied(new Vector2d(1, 1)));
        assertFalse(map.isOccupied(new Vector2d(-1, -1)));
        assertFalse(map.isOccupied(new Vector2d(Integer.MAX_VALUE-1, Integer.MIN_VALUE)));
        assertFalse(map.isOccupied(new Vector2d(Integer.MIN_VALUE+1, Integer.MIN_VALUE)));
        assertTrue(map.isOccupied(new Vector2d(2, 2)));
        assertTrue(map.isOccupied(new Vector2d(0, 0)));
    }

    @Test
    public void objectAtTest(){
        // given
        GrassField map = new GrassField(0);
        Animal animal1 = new Animal(map, new Vector2d(0, 0));
        Animal animal2 = new Animal(map, new Vector2d(-5, -10));
        Animal animal3 = new Animal(map, new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE));
        Animal animal4 = new Animal(map, new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE));
        Grass grass1 = new Grass(new Vector2d(-5, -5));
        Grass grass2 = new Grass(new Vector2d(0, 0));

        // when
        map.place(animal1);
        map.place(animal2);
        map.place(animal3);
        map.place(animal4);
        map.grass.put(new Vector2d(-5, -5), grass1);
        map.grass.put(new Vector2d(0, 0), grass2);

        // then
        assertEquals(animal1, map.objectAt(animal1.getPosition()));
        assertEquals(animal2, map.objectAt(animal2.getPosition()));
        assertEquals(animal3, map.objectAt(animal3.getPosition()));
        assertEquals(animal4, map.objectAt(animal4.getPosition()));
        assertNull(map.objectAt(new Vector2d(5, 5)));
        assertNull(map.objectAt(new Vector2d(Integer.MAX_VALUE-1, Integer.MAX_VALUE-1)));
        assertNull(map.objectAt(new Vector2d(Integer.MIN_VALUE+1, Integer.MIN_VALUE+1)));
        assertEquals(grass1, map.objectAt(grass1.getPosition()));
        assertNotEquals(grass2, map.objectAt(grass2.getPosition()));
    }

    @Test
    public void placeTest(){
        // given
        GrassField map = new GrassField(10);
        Animal animal1 = new Animal(map, new Vector2d(0, 0));
        Animal animal2 = new Animal(map, new Vector2d(-5, -10));
        Animal animal3 = new Animal(map, new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE));
        Animal animal4 = new Animal(map, new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE));
        Grass grass1 = new Grass(new Vector2d(-5, -5));
        Grass grass2 = new Grass(new Vector2d(0, 0));

        // when
        map.grass.put(new Vector2d(-5, -5), grass1);
        map.grass.put(new Vector2d(0, 0), grass2);

        // then
        assertTrue(map.place(animal1));
        assertTrue(map.place(animal2));
        assertTrue(map.place(animal3));
        assertTrue(map.place(animal4));
    }
}
