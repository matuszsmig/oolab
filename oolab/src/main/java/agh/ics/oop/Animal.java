package agh.ics.oop;

import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

import static agh.ics.oop.MapDirection.*;

public class Animal implements IMapElement{

    private MapDirection orientation;
    private Vector2d position;
    static IWorldMap map;

    private List<IPositionChangeObserver> observers = new ArrayList<>();


    public Animal(IWorldMap map)
    {
        Animal.map = map;
        this.orientation = MapDirection.NORTH;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.orientation = NORTH;
        this.position = initialPosition;
        Animal.map = map;

        addObserver(map);
    }

    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver observer: observers){
            observer.positionChanged(oldPosition, newPosition);
        }
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
                    var oldPosition = position;
                    this.position=vector1;

                    positionChanged(oldPosition,position);
                }
            }
            case BACKWARD -> {
                Vector2d  vector1 = this.position.add(Objects.requireNonNull(this.orientation.toUnitVector()).opposite());
                if (map.canMoveTo(vector1) && !map.isOccupied(vector1)){
                    var oldPosition = position;
                    this.position=vector1;

                    positionChanged(oldPosition,position);
                }
            }
        }

    }


}