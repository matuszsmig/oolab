package agh.ics.oop;

import java.util.Objects;

import static agh.ics.oop.MapDirection.*;

public class Animal {

    private MapDirection orientation;
    private Vector2d position;
    static IWorldMap map;

    public Animal(IWorldMap map)
    {
        Animal.map = map;
        this.orientation = MapDirection.NORTH;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.orientation = NORTH;
        this.position = initialPosition;
        Animal.map = map;
    }


    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return switch (this.orientation){
            case EAST -> "E";
            case WEST -> "W";
            case NORTH -> "N";
            case SOUTH -> "S";
        };
    }

    public boolean isAt(Vector2d position){
        return position.equals(getPosition());
    }

    public void setOrientation(MapDirection orientation) {
        this.orientation = orientation;
    }

    public void setPosition(Vector2d position) {
        this.position = position;
    }

    public void move(MoveDirection direction){
        switch (direction){
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD -> {
                Vector2d  vector1 = this.position.add(Objects.requireNonNull(this.orientation.toUnitVector()));
                if (map.canMoveTo(vector1) && !map.isOccupied(vector1)){
                    this.position=vector1;
                }
            }
            case BACKWARD -> {
                Vector2d  vector1 = this.position.add(Objects.requireNonNull(this.orientation.toUnitVector()).opposite());
                if (map.canMoveTo(vector1) && !map.isOccupied(vector1)){
                    this.position=vector1;
                }
            }
        }

    }


}