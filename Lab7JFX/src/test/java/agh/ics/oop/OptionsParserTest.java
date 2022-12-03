package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class OptionsParserTest {
    @Test
    public void parseTest() {
        OptionsParser parser = new OptionsParser();

        String[] configurationShort = {"f", "b", "r", "l"};
        MoveDirection[] directionsShort = {MoveDirection.FORWARD, MoveDirection.BACKWARD,
                                           MoveDirection.RIGHT, MoveDirection.LEFT};
        assertArrayEquals(directionsShort, parser.parse(configurationShort));

        String[] configurationLong = {"forward", "backward", "right", "left"};
        MoveDirection[] directionsLong = {MoveDirection.FORWARD, MoveDirection.BACKWARD,
                                          MoveDirection.RIGHT, MoveDirection.LEFT};
        assertArrayEquals(directionsLong, parser.parse(configurationLong));
    }
}
