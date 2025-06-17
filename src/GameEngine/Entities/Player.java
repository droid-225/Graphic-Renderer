package GameEngine.Entities;

import GameEngine.Coordinate;
import GameEngine.Entity;

public class Player extends Entity {
    private int width, height;

    public Player(int id, Coordinate coords) {
        super(id, coords);
        setType(0);
        setMoveability(true);
    }

    public Player(int id, Coordinate coords, int width, int height) {
        super(id, coords);
        setType(0);
        setMoveability(true);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {return width;}
    public void setWidth(int newWidth) {width = newWidth;}

    public int getHeight() {return height;}
    public void setHeight(int newHeight) {height = newHeight;}
}
