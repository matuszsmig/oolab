package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{

    protected HashMap<Vector2d, Animal> animals = new HashMap<Vector2d, Animal>();

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        animals.put(newPosition, animals.get(oldPosition));
        animals.remove(oldPosition);
    }

    @Override
    public boolean place(Animal animal) {
        if (!this.isOccupied(animal.getPosition()) && this.canMoveTo(animal.getPosition())){
            animals.put(animal.getPosition(), animal);
            return true;
        } return false;

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return this.objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Vector2d animalPos : animals.keySet()) {
            if (animalPos.equals(position)){
                return animals.get(animalPos);
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
