package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//given
//when
//then
//assert...

public class AnimalTest {
    @Test
    public void isAtTest() {
        Animal animal = new Animal(new RectangularMap(10, 5), new Vector2d(2,2));

        assertTrue(animal.isAt(new Vector2d(2,2)));
        animal.move(MoveDirection.RIGHT);
        assertTrue(animal.isAt(new Vector2d(2,2)));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(3,2)));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(4,2)));
        animal.move(MoveDirection.FORWARD);
        assertFalse(animal.isAt(new Vector2d(5,2)));
        assertTrue(animal.isAt(new Vector2d(4,2)));
        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.isAt(new Vector2d(3,2)));
        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.isAt(new Vector2d(2,2)));
        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.isAt(new Vector2d(1,2)));
        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.isAt(new Vector2d(0,2)));
        animal.move(MoveDirection.BACKWARD);
        assertFalse(animal.isAt(new Vector2d(-1,2)));
        assertTrue(animal.isAt(new Vector2d(0,2)));
    }

    @Test
    public void moveTest() {
        IWorldMap map = new RectangularMap(4, 4);
        Animal animal = new Animal(map, new Vector2d(2, 2));

        assertEquals(animal.getDirection(), MapDirection.NORTH);
        assertEquals(animal.getPosition(), new Vector2d(2,2));

        animal.move(MoveDirection.LEFT);
        assertEquals(animal.getDirection(), MapDirection.WEST);
        assertEquals(animal.getPosition(), new Vector2d(2,2));
        animal.move(MoveDirection.LEFT);
        assertEquals(animal.getDirection(), MapDirection.SOUTH);
        assertEquals(animal.getPosition(), new Vector2d(2,2));
        animal.move(MoveDirection.LEFT);
        assertEquals(animal.getDirection(), MapDirection.EAST);
        assertEquals(animal.getPosition(), new Vector2d(2,2));

        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getDirection(), MapDirection.EAST);
        assertEquals(animal.getPosition(), new Vector2d(3,2));
        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getDirection(), MapDirection.EAST);
        assertEquals(animal.getPosition(), new Vector2d(4,2));
        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getDirection(), MapDirection.EAST);
        assertEquals(animal.getPosition(), new Vector2d(4,2));

        animal.move(MoveDirection.RIGHT);
        assertEquals(animal.getDirection(), MapDirection.SOUTH);
        assertEquals(animal.getPosition(), new Vector2d(4,2));
        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getDirection(), MapDirection.SOUTH);
        assertEquals(animal.getPosition(), new Vector2d(4,1));
        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getDirection(), MapDirection.SOUTH);
        assertEquals(animal.getPosition(), new Vector2d(4,0));
        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getDirection(), MapDirection.SOUTH);
        assertEquals(animal.getPosition(), new Vector2d(4,0));

        animal.move(MoveDirection.LEFT);
        assertEquals(animal.getDirection(), MapDirection.EAST);
        assertEquals(animal.getPosition(), new Vector2d(4,0));
        animal.move(MoveDirection.BACKWARD);
        assertEquals(animal.getDirection(), MapDirection.EAST);
        assertEquals(animal.getPosition(), new Vector2d(3,0));
        animal.move(MoveDirection.BACKWARD);
        assertEquals(animal.getDirection(), MapDirection.EAST);
        assertEquals(animal.getPosition(), new Vector2d(2,0));
        animal.move(MoveDirection.BACKWARD);
        assertEquals(animal.getDirection(), MapDirection.EAST);
        assertEquals(animal.getPosition(), new Vector2d(1,0));
        animal.move(MoveDirection.BACKWARD);
        assertEquals(animal.getDirection(), MapDirection.EAST);
        assertEquals(animal.getPosition(), new Vector2d(0,0));
        animal.move(MoveDirection.BACKWARD);
        assertEquals(animal.getDirection(), MapDirection.EAST);
        assertEquals(animal.getPosition(), new Vector2d(0,0));

        animal.move(MoveDirection.LEFT);
        assertEquals(animal.getDirection(), MapDirection.NORTH);
        assertEquals(animal.getPosition(), new Vector2d(0,0));
        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getDirection(), MapDirection.NORTH);
        assertEquals(animal.getPosition(), new Vector2d(0,1));
        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getDirection(), MapDirection.NORTH);
        assertEquals(animal.getPosition(), new Vector2d(0,2));
        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getDirection(), MapDirection.NORTH);
        assertEquals(animal.getPosition(), new Vector2d(0,3));
        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getDirection(), MapDirection.NORTH);
        assertEquals(animal.getPosition(), new Vector2d(0,4));
        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getDirection(), MapDirection.NORTH);
        assertEquals(animal.getPosition(), new Vector2d(0,4));

        animal.move(MoveDirection.LEFT);
        assertEquals(animal.getDirection(), MapDirection.WEST);
        assertEquals(animal.getPosition(), new Vector2d(0,4));
        animal.move(MoveDirection.BACKWARD);
        assertEquals(animal.getDirection(), MapDirection.WEST);
        assertEquals(animal.getPosition(), new Vector2d(1,4));
        animal.move(MoveDirection.BACKWARD);
        assertEquals(animal.getDirection(), MapDirection.WEST);
        assertEquals(animal.getPosition(), new Vector2d(2,4));
        animal.move(MoveDirection.BACKWARD);
        assertEquals(animal.getDirection(), MapDirection.WEST);
        assertEquals(animal.getPosition(), new Vector2d(3,4));
        animal.move(MoveDirection.BACKWARD);
        assertEquals(animal.getDirection(), MapDirection.WEST);
        assertEquals(animal.getPosition(), new Vector2d(4,4));
        animal.move(MoveDirection.BACKWARD);
        assertEquals(animal.getDirection(), MapDirection.WEST);
        assertEquals(animal.getPosition(), new Vector2d(4,4));
    }

}
