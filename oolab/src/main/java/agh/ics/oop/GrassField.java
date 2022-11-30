package agh.ics.oop;

import java.util.*;
import java.util.List;
import java.util.ArrayList;

public class GrassField extends AbstractWorldMap{
    private final int numberOfGrasses;
    protected HashMap<Vector2d, Grass> grasses = new HashMap<Vector2d, Grass>();
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
        while (numberOfGrasses-1 >= grasses.size()) {
            int randomIndex = number.nextInt(grassPositions.size());
            Vector2d grassPosition = grassPositions.get(randomIndex);
            if (objectAt(grassPosition) == null && !isOccupied((grassPosition))) {
                grasses.put(grassPosition ,new Grass(grassPosition));
            }   else {
                new IllegalArgumentException(grassPosition + " avaliable for this grass");
            }
        }
    }


    @Override
    public Object objectAt(Vector2d position) {
        Object foundObject = super.objectAt(position);
        if (foundObject==null){
            return grasses.get(position);
        }
        return foundObject;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        for (Vector2d animalPos : animals.keySet()){
            if (animalPos.equals(position)){
                return false;
            }
        }
        return true;
    }

    public Vector2d findRightTopCorner() {
        Vector2d upperRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for (Vector2d kepka : grasses.keySet()){
            upperRight = kepka.upperRight(upperRight);
        }
        for (Vector2d animalPos : animals.keySet()){
            upperRight = animalPos.upperRight(upperRight);
        }
        return upperRight;
    }
    public Vector2d findLeftBottomCorner() {
        Vector2d lowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (Vector2d kepka : grasses.keySet()){
            lowerLeft = kepka.lowerLeft(lowerLeft);
        }
        for (Vector2d animalPos : animals.keySet()){
            lowerLeft = animalPos.lowerLeft(lowerLeft);
        }
        return lowerLeft;
    }


}
