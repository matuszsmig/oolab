package agh.ics.oop;

import java.util.List;
import java.util.ArrayList;
public class SimulationEngine implements IEngine{
    private MoveDirection[] directions;
    private IWorldMap map;
    private Vector2d[] positions;
    private final List<Animal> animals = new ArrayList<>();
    public SimulationEngine (MoveDirection[] directions, IWorldMap map, Vector2d[] positions){
        this.directions = directions;
        this.map = map;
        this.positions = positions;

        for (Vector2d position : positions) {
            Animal animal=new Animal(map, position);
            if(map.place(animal)){
                animals.add(animal);
            }
        }
    }
    @Override
    public void run() {
        int numOfAnimals = animals.size();
        for (int i=0;i<directions.length;i++){
            animals.get(i%numOfAnimals).move(directions[i]);
        }
    }


}