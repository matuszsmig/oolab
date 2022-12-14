package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimulationEngineTest {

    @Test
    void simpleTest() {
        String[] moves = {"f", "r", "l", "r", "f","f", "l"};
        MoveDirection[] directions = new OptionsParser().parse(moves);
        IWorldMap map = new RectangularMap(7,3);
        Vector2d[] positions = { new Vector2d(0,0), new Vector2d(3,3), new Vector2d(3,1) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(0,1)));
        assertFalse(map.isOccupied(new Vector2d(4,2)));
        assertTrue(map.isOccupied(new Vector2d(4,3)));
    }

    @Test
    void addingAnimals() {
        String[] moves = {};
        MoveDirection[] directions = new OptionsParser().parse(moves);
        IWorldMap map = new RectangularMap(4,4);
        Vector2d[] positions = { new Vector2d(0,0), new Vector2d(3,3), new Vector2d(3,3),
        new Vector2d(0,1), new Vector2d(0,3) ,new Vector2d(0,0)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertFalse(map.place(new Animal(map, new Vector2d(0,0))));
        assertFalse(map.place(new Animal(map, new Vector2d(0,1))));
        assertTrue(map.place(new Animal(map, new Vector2d(0,2))));
    }

    @Test
    void goingOutOfMap() {
        String[] moves = {"f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(moves);
        IWorldMap map = new RectangularMap(3,5);
        Vector2d[] positions = { new Vector2d(3,3)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(3,5)));
        assertFalse(map.isOccupied(new Vector2d(3,6)));
    }

}