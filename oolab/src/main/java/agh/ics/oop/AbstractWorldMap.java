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


}
