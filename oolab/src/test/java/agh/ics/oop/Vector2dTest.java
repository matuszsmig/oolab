package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Vector2dTest {
    Vector2d vector1 = new Vector2d(2,1);
    Vector2d vector2 = new Vector2d(-1,2);

    @Test
    void vectrorsCompare(){
        assertEquals(vector1.equals(vector2), false);
    }

    @Test
    void vectorToString(){
        assertEquals(vector1.toString(), "(2, 1)");
    }

    @Test
    void precedesVectors(){
        assertEquals(vector1.precedes(vector2), false);
    }

    @Test
    void followsVectors(){
        assertEquals(vector1.follows(vector2), false);
    }

    @Test
    void upperRightOfVectors(){
        assertEquals(vector1.upperRight(vector2), new Vector2d(2,2));
    }

    @Test
    void lowerLeftOfVectors(){
        assertEquals(vector1.lowerLeft(vector2), new Vector2d(-1,1));
    }

    @Test
    void addingVectors(){
        assertEquals(vector1.add(vector2), new Vector2d(1,3));
    }

    @Test
    void subtractingVectors(){
        assertEquals(vector1.subtract(vector2), new Vector2d(3,-1));
    }

    @Test
    void oppositeOfVector(){
        assertEquals(vector1.opposite(), new Vector2d(1,2));
    }

}