package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap{

    protected List<Animal> animals = new ArrayList<>();


    @Override
    public boolean place(Animal animal) {
        if (!this.isOccupied(animal.getPosition()) && this.canMoveTo(animal.getPosition())){
            animals.add(animal);
            return true;

        } return false;

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return this.objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal zwierzatko : animals) {
            if (zwierzatko.isAt(position)){
                return zwierzatko;
            }
        }
        return null;
    }
    public abstract Vector2d findLeftBottomCorner();
    public abstract Vector2d findRightTopCorner();

    @Override
    public String toString() {
        MapVisualizer mapVisualizer=new MapVisualizer(this);
        return mapVisualizer.draw(findLeftBottomCorner(), findRightTopCorner());
    }
}
