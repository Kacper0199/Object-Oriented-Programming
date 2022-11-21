package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class SimulationEngineTest{
    @Test
    public void worldSimulationTest() throws InterruptedException {
        // given
        String[] dirArgs1 = {"f", "b", "r", "l", "f", "f"};
        String[] dirArgs2 = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        IWorldMap map1 = new RectangularMap(10, 5);
        IWorldMap map2 = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2, 2), new Vector2d(3, 4) };
        MoveDirection[] directions1 = OptionsParser.parse(dirArgs1);
        MoveDirection[] directions2 = OptionsParser.parse(dirArgs2);
        SimulationEngine engine1 = new SimulationEngine(directions1, map1, positions);
        SimulationEngine engine2 = new SimulationEngine(directions2, map2, positions);

        // when
        engine1.run();
        engine2.run();

        // then
        assertEquals(engine1.animals.get(0).getPosition(), new Vector2d(2, 3));
        assertEquals(engine1.animals.get(0).getDirection(), MapDirection.EAST);
        assertNotEquals(engine1.animals.get(0).getPosition(), new Vector2d(3, 3));
        assertEquals(engine1.animals.get(1).getPosition(), new Vector2d(3, 3));
        assertEquals(engine1.animals.get(1).getDirection(), MapDirection.WEST);
        assertNotEquals(engine1.animals.get(1).getPosition(), new Vector2d(2, 3));

        assertEquals(engine2.animals.get(0).getPosition(), new Vector2d(2, 0));
        assertEquals(engine2.animals.get(0).getDirection(), MapDirection.SOUTH);
        assertNotEquals(engine2.animals.get(0).getPosition(), new Vector2d(2, -1));
        assertNotEquals(engine2.animals.get(1).getPosition(), new Vector2d(3, 5));
        assertEquals(engine2.animals.get(1).getDirection(), MapDirection.NORTH);
        assertNotEquals(engine2.animals.get(1).getPosition(), new Vector2d(3, 7));
    }
}