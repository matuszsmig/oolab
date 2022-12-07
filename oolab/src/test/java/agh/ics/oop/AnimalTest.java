package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AnimalTest {

    IWorldMap map = new RectangularMap(5,5);
    Animal camel = new Animal(map,new Vector2d(2,2));
    Animal eagle = new Animal(map,new Vector2d(2,2));
    Animal elephant = new Animal(map,new Vector2d(2,2));
    @Test
    void corectOrientationOfAnimal() {

        //when
        camel.move(MoveDirection.LEFT);
        camel.move(MoveDirection.LEFT);
        eagle.move(MoveDirection.LEFT);
        elephant.move(MoveDirection.RIGHT);

        //then
        assertEquals(MapDirection.SOUTH, camel.getOrientation());
        assertEquals(MapDirection.WEST, eagle.getOrientation());
        assertEquals(MapDirection.EAST, elephant.getOrientation());
    }

    @Test
    void animalMovesProperly() {

        //when
        camel.move(MoveDirection.FORWARD);

        eagle.move(MoveDirection.LEFT);
        eagle.move(MoveDirection.BACKWARD);
        eagle.move(MoveDirection.BACKWARD);

        elephant.move(MoveDirection.LEFT);
        elephant.move(MoveDirection.FORWARD);
        elephant.move(MoveDirection.LEFT);
        elephant.move(MoveDirection.FORWARD);

        //then
        assertEquals(camel.getPosition(), new Vector2d(2,3));
        assertEquals(eagle.getPosition(), new Vector2d(4,2));
        assertEquals(elephant.getPosition(), new Vector2d(1,1));

    }

    @Test
    void mapGotTheBorders(){

        //when
        eagle.move(MoveDirection.LEFT);
        eagle.move(MoveDirection.FORWARD);
        eagle.move(MoveDirection.FORWARD);
        eagle.move(MoveDirection.FORWARD);
        eagle.move(MoveDirection.LEFT);
        eagle.move(MoveDirection.FORWARD);
        eagle.move(MoveDirection.FORWARD);
        eagle.move(MoveDirection.FORWARD);

        //then

        assertTrue(eagle.isAt(new Vector2d(0,0)));
        assertFalse(eagle.isAt(new Vector2d(-1,-1)));
    }
    @Test
    void parserWorksCorrectly(){
        //given
        String[] moves1 = {"f","forward", "right", "light", "left"};
        String[] moves2 = {"f","forward", "right", "f", "r"};
        MoveDirection[] directionsMoves1 = {MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.RIGHT,MoveDirection.LEFT};
        MoveDirection[] directionsMoves2 = {MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.RIGHT,MoveDirection.FORWARD,MoveDirection.RIGHT};

        //when
        MoveDirection[] directions1 = new OptionsParser().parse(moves1);
        MoveDirection[] directions2 = new OptionsParser().parse(moves2);

        //then
        assertArrayEquals(directions1, directionsMoves1);
        assertArrayEquals(directions2, directionsMoves2);

    }

}