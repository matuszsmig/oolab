package agh.ics.oop;

import java.util.*;
import java.util.List;
import java.util.ArrayList;

public class GrassField extends AbstractWorldMap{
    private final int numberOfGrasses;
    public GrassField(int numberOfGrasses) {
        this.numberOfGrasses = numberOfGrasses;
        placeGrass(this.numberOfGrasses);
    }

    public void placeGrass(int numOfGrass){
        List<Vector2d> grassPositions = new ArrayList<>();
        for (int i = 0; i < Math.sqrt(numOfGrass*10); i++){
            for (int j = 0; j < Math.sqrt(numOfGrass*10); j++){
                grassPositions.add(new Vector2d(i,j));
            }
        }

        Random number = new Random();
        for (int i = 0; i < numOfGrass; ++i) {
            int randomIndex = number.nextInt(grassPositions.size());
            Vector2d grassPosition = grassPositions.get(randomIndex);
            if (!isOccupied(grassPosition)) {
                grasses.add(new Grass(grassPosition));
            }
        }
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        for (Animal zwierzatko : animals){
            if (zwierzatko.isAt(position)){
                return false;
            }
        }
        return true;
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
        return this.objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal zwierzatko : animals) {
            if (zwierzatko.isAt(position)){
                return zwierzatko;
            }
        }
        for (Grass kepka : grasses) {
            if (kepka.getPosition().equals(position)){
                return kepka;
            }
        }
        return null;
    }

    public Vector2d findRightTopCorner() {
        Vector2d upperRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for (Grass kepka : grasses){
            upperRight = kepka.getPosition().upperRight(upperRight);
        }
        for (Animal zwierzatko: animals){
            upperRight = zwierzatko.getPosition().upperRight(upperRight);
        }
        return upperRight;
    }
    public Vector2d findLeftBottomCorner() {
        Vector2d lowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (Grass kepka : grasses){
            lowerLeft = kepka.getPosition().lowerLeft(lowerLeft);
        }
        for (Animal zwierzatko: animals){
            lowerLeft = zwierzatko.getPosition().lowerLeft(lowerLeft);
        }
        return lowerLeft;
    }


}
