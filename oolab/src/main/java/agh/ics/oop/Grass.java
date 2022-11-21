package agh.ics.oop;

public class Grass {

    private Vector2d postionOfGrass;

    public Vector2d getPosition(){
        return postionOfGrass;
    }

    @Override
    public String toString() {
        return "*";
    }
}
