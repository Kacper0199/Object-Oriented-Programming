package agh.ics.oop;

import java.util.Arrays;

public class OptionsParser {

    public static MoveDirection[] parse(String[] directions) throws IllegalArgumentException{

        return Arrays.stream(directions).map(s -> switch(s) {
            case "r", "right" -> MoveDirection.RIGHT;
            case "l", "left" -> MoveDirection.LEFT;
            case "f", "forward" -> MoveDirection.FORWARD;
            case "b", "backward" -> MoveDirection.BACKWARD;
            default -> throw new IllegalArgumentException(Arrays.toString(directions) + " is not legal move specification.");
        }).toArray(MoveDirection[]::new);
    }
}
