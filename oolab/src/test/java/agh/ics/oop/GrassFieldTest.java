package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {
    IWorldMap map = new GrassField (10);
    Animal eagle = new Animal(map,new Vector2d(0,0));
    Animal mokey = new Animal(map, new Vector2d(0,0));
    Animal donkey = new Animal(map, new Vector2d(1,1));

    @Test
    void canMoveTo(){
        map.place(eagle);
        assertTrue(map.canMoveTo(new Vector2d(1,1)));
        map.place(donkey);
        assertFalse(map.canMoveTo(new Vector2d(1,1)));
    }

    @Test
    void canBePlaced(){
        assertTrue(map.place(eagle));
        assertFalse(map.place(mokey));
        assertTrue(map.place(donkey));
    }

    @Test
    void isPositionOcuppied(){
        map.place(eagle);
        map.place(donkey);
        assertTrue(map.isOccupied(new Vector2d(0,0)));
        assertTrue(map.isOccupied(new Vector2d(1,1)));
        assertFalse(map.isOccupied(new Vector2d(1,0)));
    }

    @Test
    void isThereObjectAt(){
        map.place(eagle);
        map.place(donkey);
        assertEquals(eagle,map.objectAt(new Vector2d(0,0)));
        assertEquals(donkey,map.objectAt(new Vector2d(1,1)));
    }

}