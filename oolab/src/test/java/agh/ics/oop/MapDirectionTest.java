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
        //given
        MapDirection north = MapDirection.NORTH;
        MapDirection south = MapDirection.SOUTH;
        MapDirection west = MapDirection.WEST;
        MapDirection east = MapDirection.EAST;

        //when
        MapDirection northPrev = north.previous();
        MapDirection southPrev = south.previous();
        MapDirection westPrev = west.previous();
        MapDirection eastPrev = east.previous();

        //then
        assertEquals(MapDirection.WEST, northPrev);
        assertEquals(MapDirection.EAST, southPrev);
        assertEquals(MapDirection.SOUTH, westPrev);
        assertEquals(MapDirection.NORTH, eastPrev);
    }
}
