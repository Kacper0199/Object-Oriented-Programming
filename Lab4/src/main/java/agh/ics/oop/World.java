package agh.ics.oop;

public class World {
    public static void main(String[] args) {
// LAB 1
//        Direction[] directions = StrToDirection(args);
//        System.out.println("System wystartowal");
//        run(directions);
//        System.out.println("System zakonczyl swoje dzialanie");


// LAB 2
//        Vector2d position1 = new Vector2d(1,2);
//        System.out.println(position1);
//        Vector2d position2 = new Vector2d(-2,1);
//        System.out.println(position2);
//        System.out.println(position1.add(position2));

//        MapDirection south = MapDirection.SOUTH;
//        System.out.println(south.toString());
//        System.out.println(south.next());
//        System.out.println(south.previous());
//        System.out.println(south.toUnitVector());


// LAB 3
//        Animal animal1 = new Animal();

//        System.out.println(animal1);
//        animal1.move(MoveDirection.RIGHT);
//        System.out.println(animal1);
//        animal1.move(MoveDirection.LEFT);
//        System.out.println(animal1);
//        animal1.move(MoveDirection.LEFT);
//        System.out.println(animal1);
//        animal1.move(MoveDirection.LEFT);
//        System.out.println(animal1);
//
//        System.out.println();
//
//        animal1.move(MoveDirection.FORWARD);
//        System.out.println(animal1);
//        animal1.move(MoveDirection.FORWARD);
//        System.out.println(animal1);
//        animal1.move(MoveDirection.FORWARD);
//        System.out.println(animal1);
//        animal1.move(MoveDirection.FORWARD);
//        System.out.println(animal1);
//
//        System.out.println();
//
//        animal1.move(MoveDirection.BACKWARD);
//        System.out.println(animal1);
//        animal1.move(MoveDirection.BACKWARD);
//        System.out.println(animal1);
//        animal1.move(MoveDirection.BACKWARD);
//        System.out.println(animal1);
//        animal1.move(MoveDirection.BACKWARD);
//        System.out.println(animal1);
//        animal1.move(MoveDirection.BACKWARD);
//        System.out.println(animal1);
//        animal1.move(MoveDirection.BACKWARD);
//        System.out.println(animal1);
//
//        System.out.println();
//
//        animal1.move(MoveDirection.RIGHT);
//        System.out.println(animal1);
//        animal1.move(MoveDirection.BACKWARD);
//        System.out.println(animal1);
//        animal1.move(MoveDirection.BACKWARD);
//        System.out.println(animal1);
//        animal1.move(MoveDirection.BACKWARD);
//        System.out.println(animal1);
//        animal1.move(MoveDirection.FORWARD);
//        System.out.println(animal1);
//        animal1.move(MoveDirection.FORWARD);
//        System.out.println(animal1);
//        animal1.move(MoveDirection.FORWARD);
//        System.out.println(animal1);
//
//        System.out.println();
//
//        animal1.move(MoveDirection.RIGHT);
//        System.out.println(animal1);
//        animal1.move(MoveDirection.RIGHT);
//        System.out.println(animal1);
//        animal1.move(MoveDirection.BACKWARD);
//        System.out.println(animal1);
//        animal1.move(MoveDirection.BACKWARD);
//        System.out.println(animal1);
//
//        System.out.println();
//
//        animal1.move(MoveDirection.LEFT);
//        System.out.println(animal1);
//        animal1.move(MoveDirection.BACKWARD);
//        System.out.println(animal1);
//        animal1.move(MoveDirection.BACKWARD);
//        System.out.println(animal1);
//        animal1.move(MoveDirection.BACKWARD);
//        System.out.println(animal1);
//        animal1.move(MoveDirection.FORWARD);
//        System.out.println(animal1);


// LAB 4
//        Animal animal1 = new Animal();
//        OptionsParser parser = new OptionsParser();
//        MoveDirection[] directions = parser.parse(args);
//
//        Arrays.stream(directions).
//                forEach(dir -> {animal1.move(dir);
//                        System.out.println(animal1);});


        // LAB 5
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        System.out.println(engine);
        engine.run();
    }
}
