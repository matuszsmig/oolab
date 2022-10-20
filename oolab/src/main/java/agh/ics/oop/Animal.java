package agh.ics.oop;

public class Animal {

    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "orientation=" + orientation + ", position=" + position;
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
            case RIGHT -> setOrientation(orientation.next());
            case LEFT -> setOrientation(orientation.previous());
            case FORWARD -> {
                switch (orientation){
                    case NORTH -> {
                        if (getPosition().add(new Vector2d(0,1)).precedes(new Vector2d(4,4))){
                            setPosition(position.add(new Vector2d(0,1)));}
                    }
                    case SOUTH ->{
                        if (getPosition().add(new Vector2d(0,-1)).follows(new Vector2d(0,0))){
                            setPosition(position.add(new Vector2d(0,-1)));
                        }
                    }
                    case EAST -> {
                        if (getPosition().add(new Vector2d(1,0)).precedes(new Vector2d(4,4))){
                            setPosition(position.add(new Vector2d(1,0)));
                        }
                    }
                    case WEST -> {
                        if (getPosition().add(new Vector2d(-1,0)).follows(new Vector2d(0,0))){
                            setPosition(position.add(new Vector2d(-1,0)));
                        }
                    }
                }
            }
            case BACKWARD -> {
                switch (orientation){
                    case NORTH -> {
                        if (getPosition().add(new Vector2d(0,-1)).follows(new Vector2d(0,0))){
                            setPosition(position.add(new Vector2d(0,-1)));
                        }
                    }
                    case SOUTH -> {
                        if (getPosition().add(new Vector2d(0,1)).precedes(new Vector2d(4,4))){
                            setPosition(position.add(new Vector2d(0,1)));}
                    }
                    case EAST -> {
                        if (getPosition().add(new Vector2d(-1,0)).follows(new Vector2d(0,0))){
                            setPosition(position.add(new Vector2d(-1,0)));
                        }
                    }
                    case WEST -> {
                        if (getPosition().add(new Vector2d(1,0)).precedes(new Vector2d(4,4))){
                            setPosition(position.add(new Vector2d(1,0)));
                        }
                    }
                }
            }
        }
    }


}
