package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//W metodach testujących można użyć np. następujących asercji:
//
//        assertEquals(a, b) - weryfikuje czy obiekty a i b są sobie równe (korzystając z metody equals),
//        assertTrue(a) - weryfikuje czy wartość logiczna a jest prawdą,
//        assertFalse(a) - weryfikuje czy wartość logiczna a jest fałszem.


//Zaimplementuj test weryfikujący poprawność działania metody next(), dla wszystkich przypadków (dodaj anotację @Test przed deklaracją metody).
//        Uruchom test korzystając z zielonych trójkątów po lewej stronie.
//        Zaimplementuj test weryfikujący poprawność działania metody previous(), dla wszystkich przypadków.
//        Utwórz klasę Vector2dTest.
//        Dodaj testy weryfikujące poprawność metod: equals(Object other), toString(), precedes(Vector2d other),
//        follows(Vector2d other), upperRight(Vector2d other), lowerLeft(Vector2d other), add(Vector2d other),
//        subtract(Vector2d other), opposite().


public class MapDirectionTest {
    @Test
    public void nextTest() {
        assertEquals(MapDirection.NORTH, MapDirection.WEST.next());
        assertEquals(MapDirection.EAST, MapDirection.NORTH.next());
        assertEquals(MapDirection.SOUTH, MapDirection.EAST.next());
        assertEquals(MapDirection.WEST, MapDirection.SOUTH.next());
    }

    @Test
    public void previousTest() {
        assertEquals(MapDirection.NORTH, MapDirection.EAST.previous());
        assertEquals(MapDirection.EAST, MapDirection.SOUTH.previous());
        assertEquals(MapDirection.SOUTH, MapDirection.WEST.previous());
        assertEquals(MapDirection.WEST, MapDirection.NORTH.previous());
    }

}
