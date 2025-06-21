package PhysicsEngine;

public class Coordinate {
    private int xPos, yPos;

    public Coordinate(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public String toString() {
        return "(" + xPos + "," + yPos + ")";
    }

    public int getXPos() {return xPos;}
    public void setXPos(int newXPos) {xPos = newXPos;}

    public int getYPos() {return yPos;}
    public void setYPos(int newYPos) {yPos = newYPos;}
}
