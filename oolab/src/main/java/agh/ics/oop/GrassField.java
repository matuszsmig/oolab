package agh.ics.oop;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Vector;

public class GrassField extends AbstractWorldMap{
    private int numberOfGrasses;

    private final List<Vector2d> grasses = new ArrayList<>();



    @Override
    public boolean canMoveTo(Vector2d position) {
        return false;
    }


    @Override
    public boolean isOccupied(Vector2d position) {
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return null;
    }
}
