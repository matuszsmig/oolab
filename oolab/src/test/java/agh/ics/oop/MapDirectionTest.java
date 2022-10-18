package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {

    @Test
    void nextWorks(){
        MapDirection nor = MapDirection.NORTH;
        MapDirection norNext = nor.next();
        assertEquals(norNext, MapDirection.EAST);

    }

    @Test
    void previousWorks(){
        MapDirection north = MapDirection.NORTH;
        MapDirection south = MapDirection.SOUTH;
        MapDirection west = MapDirection.WEST;
        MapDirection east = MapDirection.EAST;

        MapDirection northPrev = north.previous();
        MapDirection southPrev = south.previous();
        MapDirection westPrev = west.previous();
        MapDirection eastPrev = east.previous();

        assertEquals(northPrev, MapDirection.WEST);
        assertEquals(southPrev, MapDirection.EAST);
        assertEquals(westPrev, MapDirection.SOUTH);
        assertEquals(eastPrev, MapDirection.NORTH);
    }
}
