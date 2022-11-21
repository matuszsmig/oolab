package agh.ics.oop;

public class World {
    public static void run(Direction[] directions){
        System.out.println("Start");
        for(Direction direction : directions){
            switch (direction) {
                case forward -> System.out.println("zwierzak idzie do przodu");
                case backward -> System.out.println("zwierzak idzie do tyłu");
                case rightward -> System.out.println("zwierzak skręca w prawo");
                case leftward -> System.out.println("zwierzak skręca w lewo");
            }
        }
        System.out.println("Stop");
    }

    public static void convert(String[] elements, Direction[] newElements){
        for(int i = 0; i < elements.length; i++){
            switch (elements[i]) {
                case "f" -> newElements[i] = Direction.forward;
                case "b" -> newElements[i] = Direction.backward;
                case "r" -> newElements[i] = Direction.rightward;
                case "l" -> newElements[i] = Direction.leftward;
            }
        }

    }

    public static void main(String[] args) {
        //System.out.println("system wystartował");
        //int rozmiar = args.length;
        //Direction[] directions = new Direction[rozmiar];
        //convert(args, directions);
        //run(directions);
        //System.out.println("system zakończył działanie")

        //Vector2d position1 = new Vector2d(1,2);
        //System.out.println(position1);
        //Vector2d position2 = new Vector2d(-2,1);
        //System.out.println(position2);
        //System.out.println(position1.add(position2));

        //Animal mouse = new Animal();
        //mouse.move(MoveDirection.RIGHT);
        //mouse.move(MoveDirection.FORWARD);
        //mouse.move(MoveDirection.FORWARD);
        //mouse.move(MoveDirection.FORWARD);
        //System.out.println(mouse.toString());
        //System.out.println();


        //Animal animal = new Animal();
        //MoveDirection[] directions = new OptionsParser().parse(args);

        //for (MoveDirection direction : directions) {
        //    animal.move(direction);
        //    System.out.println(animal.toString());
        //}


        //mechanizm, który wyklucza pojawienie się dwóch zwierząt w tym samym miejscu, można zaimplementować
        //wykonując operacje w kolejności: pobranie pozycji obu zwierząt -> wywołanie metody isAT(), porównjącej
        //pozyję zwierzaka1 z odpowiednio wywyołanym ruchem, oraz pozycję zwierzak2 z odpowiednio wywyołanym ruchem
        //-> jeżeli zwróci false możemy wykonać ruch, w przeciwnym wypadku nie możemy (zakładamy że pozycje startowe
        //się róznią)

        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        System.out.println(map);


    }

}