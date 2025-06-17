package GameEngine.Entities;

import GameEngine.Coordinate;
import GameEngine.Entity;

public class Obstacle extends Entity {
    private int width, height;

    public Obstacle(int id, Coordinate coords, boolean movable) {
        super(id, coords);
        setType(0);
        setMoveability(movable);
    }

    public Obstacle(int id, Coordinate coords, boolean movable, int width, int height) {
        super(id, coords);
        setType(0);
        setMoveability(movable);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {return width;}
    public void setWidth(int newWidth) {width = newWidth;}

    public int getHeight() {return height;}
    public void setHeight(int newHeight) {height = newHeight;}
}
