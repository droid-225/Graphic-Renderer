package GameEngine;

public class Entity {
    private Coordinate coords;
    private int type, id;
    private boolean movable = false;

    public Entity(int id, Coordinate coords) {
        this.id = id;
        this.coords = coords;

    }

    public Coordinate getPosition() {return coords;}
    public void setPosition(Coordinate newCoords) {coords = newCoords;}

    public int getType() {return type;}
    public void setType(int newType) {type = newType;}

    public int getID() {return id;}
    public void setID(int newID) {id = newID;}

    public boolean isMovable() {return movable;}
    public void setMoveability(boolean movable) {this.movable = movable;}
}
