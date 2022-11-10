package agh.ics.oop;

import java.util.List;
import java.util.ArrayList;
public class SimulationEngine implements IEngine{
    public MoveDirection[] directions;
    public IWorldMap map;
    public Vector2d[] positions;
    private final List<Animal> animals = new ArrayList<>();
    public SimulationEngine (MoveDirection[] directions, IWorldMap map, Vector2d[] positions){
        this.directions = directions;
        this.map = map;
        this.positions = positions;

        for (Vector2d position : positions) {
            map.place(new Animal(map, position));
            if(map.place(new Animal(map, position))){
                animals.add(new Animal(map, position));
            }
        }
    }
    @Override
    public void run() {
        int numOfAnimals = animals.size();
        for (int i=0;i<directions.length;i++){

        }
    }


}
