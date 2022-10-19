package agh.ics.oop;

public class World {
    public static void run(Direction[] directions){
        System.out.println("Start");
        for(Direction direction : directions){
            switch (direction) {
                case forward:
                    System.out.println("zwierzak idzie do przodu");
                    break;
                case backward:
                    System.out.println("zwierzak idzie do tyłu");
                    break;
                case rightward:
                    System.out.println("zwierzak skręca w prawo");
                    break;
                case leftward:
                    System.out.println("zwierzak skręca w lewo");
                    break;
            }
        }
        System.out.println("Stop");
    }

    public static void convert(String[] elements, Direction[] newElements){
        for(int i = 0; i < elements.length; i++){
            switch (elements[i]) {
                case "f":
                    newElements[i] = Direction.forward;
                    break;
                case "b":
                    newElements[i] = Direction.backward;
                    break;
                case "r":
                    newElements[i] = Direction.rightward;
                    break;
                case "l":
                    newElements[i] = Direction.leftward;
                    break;
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

        Animal animal = new Animal();
        System.out.println(animal.getPosition());

    }

}
