package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class Vector2dTest {
    int MAX_INT = Integer.MAX_VALUE;
    int MIN_INT = Integer.MIN_VALUE;

    @Test
    public void equalsTest() {
        Vector2d vect1 = new Vector2d(5, 7);
        Vector2d vect2 = new Vector2d(5, 7);
        Vector2d vect3 = new Vector2d(-5, -7);
        Vector2d vectMax = new Vector2d(MAX_INT, MAX_INT);
        Vector2d vectMin = new Vector2d(MIN_INT, MIN_INT);

        assertEquals(vect1, vect2);
        assertEquals(vect1, vect1);
        assertNotEquals(vect1, vect3);
        assertNotEquals(vect1, null);
        assertEquals(vectMax, vectMax);
        assertEquals(vectMin, vectMin);
        assertEquals(vect3.opposite(), vect1);
    }

    @Test
    public void toStringTest() {
        Vector2d vect1 = new Vector2d(1, 10);
        Vector2d vect2 = new Vector2d(0, 0);
        Vector2d vectMax = new Vector2d(MAX_INT, MAX_INT);
        Vector2d vectMin = new Vector2d(MIN_INT, MIN_INT);

        assertEquals("(1,10)", vect1.toString());
        assertEquals("(0,0)", vect2.toString());
        assertEquals("(2147483647,2147483647)", vectMax.toString());
        assertEquals("(-2147483648,-2147483648)", vectMin.toString());
    }

    @Test
    public void precedesTest() {
       Vector2d vect1 = new Vector2d(-1, -2);
       Vector2d vect2 = new Vector2d(-2, -3);
       Vector2d vect3 = new Vector2d(-2, 1);
       Vector2d vectMax = new Vector2d(MAX_INT, MAX_INT);
       Vector2d vectMin = new Vector2d(MIN_INT, MIN_INT);

       assertTrue(vect2.precedes(vect1));
       assertTrue(vect2.precedes(vect2));
       assertFalse(vect3.precedes(vect2));
       assertTrue(vectMin.precedes(vectMax));
    }

    @Test
    public void followsTest() {
        Vector2d vect1 = new Vector2d(2, -2);
        Vector2d vect2 = new Vector2d(3, -2);
        Vector2d vect3 = new Vector2d(-2, 1);
        Vector2d vectMax = new Vector2d(MAX_INT, MAX_INT);
        Vector2d vectMin = new Vector2d(MIN_INT, MIN_INT);

        assertTrue(vect2.follows(vect1));
        assertTrue(vect1.follows(vect1));
        assertFalse(vect3.follows(vect2));
        assertTrue(vectMax.follows(vectMin));
    }

    @Test
    public void upperRightTest() {
        Vector2d vect1 = new Vector2d(-100, 1);
        Vector2d vect2 = new Vector2d(-1, 100);
        Vector2d vectMax = new Vector2d(MAX_INT, MAX_INT);
        Vector2d vectMin = new Vector2d(MIN_INT, MIN_INT);

        assertEquals(vect2.upperRight(vect1), new Vector2d(-1, 100));
        assertNotEquals(vect2.upperRight(vect1), new Vector2d(-100, 100));
        assertEquals(vect1.upperRight(vect1), new Vector2d(-100, 1));
        assertEquals(vectMax.upperRight(vectMin), new Vector2d(MAX_INT, MAX_INT));
    }

    @Test
    public void lowerLeftTest() {
        Vector2d vect1 = new Vector2d(-100, 1);
        Vector2d vect2 = new Vector2d(-1, 100);
        Vector2d vectMax = new Vector2d(MAX_INT, MAX_INT);
        Vector2d vectMin = new Vector2d(MIN_INT, MIN_INT);

        assertEquals(vect2.lowerLeft(vect1), new Vector2d(-100, 1));
        assertNotEquals(vect2.lowerLeft(vect1), new Vector2d(-100, -1));
        assertEquals(vect1.lowerLeft(vect1), new Vector2d(-100, 1));
        assertEquals(vectMax.lowerLeft(vectMin), new Vector2d(MIN_INT, MIN_INT));
    }

    @Test
    public void addTest() {
        Vector2d vect1 = new Vector2d(-1, 1);
        Vector2d vect2 = new Vector2d(1, -1);
        Vector2d vect3 = new Vector2d(0, 0);
        Vector2d vectMax = new Vector2d(MAX_INT, MAX_INT);
        Vector2d vectMin = new Vector2d(MIN_INT, MIN_INT);

        assertEquals(vect1.add(vect2), new Vector2d(0, 0));
        assertEquals(vect1.add(vect3), vect1);
        assertEquals(vectMax.add(vectMin), new Vector2d(-1, -1));
    }

    @Test
    public void subtractTest() {
        Vector2d vect1 = new Vector2d(1, 1);
        Vector2d vect2 = new Vector2d(-1, -1);
        Vector2d vect3 = new Vector2d(0, 0);
        Vector2d vectMax = new Vector2d(MAX_INT, MAX_INT);
        Vector2d vectMin = new Vector2d(MIN_INT, MIN_INT);

        assertEquals(vect1.subtract(vect2), new Vector2d(2, 2));
        assertEquals(vect1.subtract(vect3), vect1);
        assertEquals(vectMax.subtract(vectMax), new Vector2d(0, 0));
        assertEquals(vectMin.subtract(vectMin), new Vector2d(0, 0));
    }

    @Test
    public void oppositeTest() {
        Vector2d vect1 = new Vector2d(-10, -10);
        Vector2d vect2 = new Vector2d(0, 0);
        Vector2d vectMax = new Vector2d(MAX_INT, MAX_INT);

        assertEquals(vect1.opposite(), new Vector2d(10, 10));
        assertEquals(vect2.opposite(), vect2);
        assertEquals(vectMax.opposite(), new Vector2d(-MAX_INT, -MAX_INT));
    }
}
