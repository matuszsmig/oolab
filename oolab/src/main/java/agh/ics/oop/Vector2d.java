package agh.ics.oop;

public class Vector2d {
    final int x;
    final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(%d, %d)".formatted(x,y);
    }

    public boolean precedes(Vector2d other){
        if (x <= other.x && y <= other.y){
            return true;
        }
        return false;
    }

    public boolean follows(Vector2d other){
        if (x >= other.x && y >= other.y){
            return true;
        }
        return false;
    }

    public Vector2d add(Vector2d other){
        return new Vector2d(x + other.x, y + other.y);
    }

    public Vector2d subtract(Vector2d other){
        return new Vector2d(x - other.x, y - other.y);
    }

    public Vector2d upperRight(Vector2d other){
        if (x < other.x && y < other.y){
            return new Vector2d(other.x,other.y);
        } else if (x < other.x && y > other.y) {
            return new Vector2d(other.x,y);
        } else if (x > other.x && y < other.y){
            return new Vector2d(x,other.y);
        } else {
            return new Vector2d(x,y);
        }
    }

    public Vector2d lowerLeft(Vector2d other){
        if (x < other.x && y < other.y){
            return new Vector2d(x,y);
        } else if (x < other.x && y > other.y) {
            return new Vector2d(x,other.y);
        } else if (x > other.x && y < other.y){
            return new Vector2d(other.x,y);
        } else {
            return new Vector2d(other.x,other.y);
        }
    }

    public Vector2d opposite(){
        return new Vector2d(y,x);
    }

    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        // tutaj przeprowadzane jest faktyczne porównanie
        if (x == that.x && y == that.y)
            return true;
        return false;
    }
}
