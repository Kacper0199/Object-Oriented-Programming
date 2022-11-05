package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class OptionsParserTest {
    @Test
    public void parseTest() {
        OptionsParser parser = new OptionsParser();

        String[] configurationWrong = {"course", "c", "go", "w"};
        MoveDirection[] directionsWrong = {};
        assertArrayEquals(directionsWrong, parser.parse(configurationWrong));

        String[] configurationShort = {"f", "b", "r", "l"};
        MoveDirection[] directionsShort = {MoveDirection.FORWARD, MoveDirection.BACKWARD,
                                           MoveDirection.RIGHT, MoveDirection.LEFT};
        assertArrayEquals(directionsShort, parser.parse(configurationShort));

        String[] configurationLong = {"forward", "backward", "right", "left"};
        MoveDirection[] directionsLong = {MoveDirection.FORWARD, MoveDirection.BACKWARD,
                                          MoveDirection.RIGHT, MoveDirection.LEFT};
        assertArrayEquals(directionsLong, parser.parse(configurationLong));


        String[] configurationDifferent = {"forward", "b", "right", "l", "course", "down",
                                           "forward", "backward", "f", "up", "u", "r"};
        MoveDirection[] directionsDifferent = {MoveDirection.FORWARD, MoveDirection.BACKWARD,
                                               MoveDirection.RIGHT, MoveDirection.LEFT,
                                               MoveDirection.FORWARD, MoveDirection.BACKWARD,
                                               MoveDirection.FORWARD, MoveDirection.RIGHT};
        assertArrayEquals(directionsDifferent, parser.parse(configurationDifferent));
    }

}
