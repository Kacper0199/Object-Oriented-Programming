package agh.ics.oop;

import java.util.Arrays;
import java.util.stream.Stream;

public class World {
    public static void main(String[] args) {
//        Direction[] directions = StrToDirection(args);
//        System.out.println("System wystartowal");
//        run(directions);
//        System.out.println("System zakonczyl swoje dzialanie");

//        Vector2d position1 = new Vector2d(1,2);
//        System.out.println(position1);
//        Vector2d position2 = new Vector2d(-2,1);
//        System.out.println(position2);
//        System.out.println(position1.add(position2));

        MapDirection south = MapDirection.SOUTH;
        System.out.println(south.toString());
        System.out.println(south.next());
        System.out.println(south.previous());
        System.out.println(south.toUnitVector());
    }

    public static void run(Direction[] args) {
        System.out.println("Zwierzak idzie do przodu");

        Stream<String> argsStream = Arrays.stream(args).map(arg -> switch(arg) {
                case RIGHT -> "Zwierzak skreca w prawo";
                case LEFT -> "Zwierzak skreca w lewo";
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tylu";
                default -> "";
        });
        argsStream.forEach(System.out::println);
    }

    public static Direction[] StrToDirection(String[] directions) {

        return Arrays.stream(directions).map(s -> switch(s) {
            case "r" -> Direction.RIGHT;
            case "l" -> Direction.LEFT;
            case "f" -> Direction.FORWARD;
            case "b" -> Direction.BACKWARD;
            default -> Direction.NONE;
        }).toList().toArray(new Direction[0]);
    }
}
