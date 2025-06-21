package PhysicsEngine;

public class Entity {
    private Coordinate coords;
    private int type, id, width, height;
    private boolean movable = false;

    public Entity(int id, Coordinate coords, int height, int width) {
        this.id = id;
        this.coords = coords;
        this.width = width;
        this.height = height;

    }

    public Coordinate getPosition() {return coords;}
    public void setPosition(Coordinate newCoords) {coords = newCoords;}

    public int getType() {return type;}
    public void setType(int newType) {type = newType;}

    public int getID() {return id;}
    public void setID(int newID) {id = newID;}

    public boolean isMovable() {return movable;}
    public void setMoveability(boolean movable) {this.movable = movable;}

    public int getWidth() {return width;}
    public void setWidth(int newWidth) {width = newWidth;}

    public int getHeight() {return height;}
    public void setHeight(int newHeight) {height = newHeight;}
}
