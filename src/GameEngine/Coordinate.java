package GameEngine;

public class Coordinate {
    public int xPos;
    public int yPos;

    public Coordinate(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public String toString() {
        return "(" + xPos + "," + yPos + ")";
    }
}
