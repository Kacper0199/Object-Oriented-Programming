package agh.ics.oop;

import java.util.Arrays;
import java.util.Objects;

public class OptionsParser {

    public MoveDirection[] parse(String[] directions){

        return Arrays.stream(directions).map(s -> switch(s) {
            case "r", "right" -> MoveDirection.RIGHT;
            case "l", "left" -> MoveDirection.LEFT;
            case "f", "forward" -> MoveDirection.FORWARD;
            case "b", "backward" -> MoveDirection.BACKWARD;
            default -> null;
        }).filter(Objects::nonNull).toArray(MoveDirection[]::new);
    }
}
