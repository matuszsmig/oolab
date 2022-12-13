package agh.ics.oop;

import agh.ics.oop.gui.App;

import java.util.List;
import java.util.ArrayList;
public class SimulationEngine implements IEngine, Runnable {
    private final MoveDirection[] directions;
    private final IWorldMap map;
    private final Vector2d[] positions;
    private final List<Animal> animals = new ArrayList<>();
    private int moveDelay;
    private App app;
    public SimulationEngine (MoveDirection[] directions, IWorldMap map, Vector2d[] positions, int moveDelay, App app){
        this.directions = directions;
        this.map = map;
        this.positions = positions;
        this.app = app;
        this.moveDelay = moveDelay;

        for (Vector2d position : positions) {
            Animal animal=new Animal(map, position);
            if(map.place(animal)){
                animals.add(animal);
            }
        }
    }
    @Override
    public void run() {
        int i = 0;
        int n = positions.length;

        //System.out.println(map);

        for (MoveDirection direction : directions) {
            Animal currentAnimal = (Animal) map.objectAt(positions[i % n]);
            if(currentAnimal != null) {
                currentAnimal.move(direction);
                positions[i % n] = currentAnimal.getPosition();
                i += 1;
            }
            app.refreshMap();
            System.out.println(map);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Wątek przerwany ");
            }

        }
    }


}