package agh.ics.oop;

public class Animal {

    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }

    public String toString() {
        return "(%d, %d)".formatted(getPosition());
    }

    //public boolean isAt(Vector2d position){
    //    return animalPosition.equals(position);
    //}


}
