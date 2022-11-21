package agh.ics.oop;

public class OptionsParser {

    public MoveDirection[] parse(String[] args){
        int size = args.length;
        MoveDirection[] newElements = new MoveDirection[size];
        int outOfMoveDirection = 0;
        for (int i = 0; i< size; i++){
            switch (args[i]){
                case "f", "forward" -> newElements[i-outOfMoveDirection] = MoveDirection.FORWARD;
                case "b", "backward" -> newElements[i-outOfMoveDirection] = MoveDirection.BACKWARD;
                case "r", "right" -> newElements[i-outOfMoveDirection] = MoveDirection.RIGHT;
                case "l", "left" -> newElements[i-outOfMoveDirection] = MoveDirection.LEFT;
                default -> outOfMoveDirection+=1;
            }
        }
        MoveDirection[] directions = new MoveDirection[size-outOfMoveDirection];
        if (size - outOfMoveDirection >= 0) System.arraycopy(newElements, 0, directions, 0, size - outOfMoveDirection);
        return directions;

    }
}
