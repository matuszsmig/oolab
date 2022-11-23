package agh.ics.oop;

import java.util.List;
import java.util.ArrayList;

public class RectangularMap implements IWorldMap {
    private final List<Animal> animals = new ArrayList<>();
    private final Vector2d bottomLeft;
    private final Vector2d topRight;

    public RectangularMap(int width, int height){
        this.bottomLeft = new Vector2d(0,0);
        this.topRight = new Vector2d(width, height);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(topRight) && position.follows(bottomLeft);
    }

    @Override
    public boolean place(Animal animal) {
        if (!this.isOccupied(animal.getPosition()) && this.canMoveTo(animal.getPosition())){
            animals.add(animal);
            return true;

        } return false;

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal zwierzatko : animals) {
            if (zwierzatko.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal zwierzatko : animals) {
            if (zwierzatko.getPosition().equals(position)){
                return zwierzatko;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        MapVisualizer mapVisualizer=new MapVisualizer(this);
        return mapVisualizer.draw(bottomLeft, topRight);
    }
}
