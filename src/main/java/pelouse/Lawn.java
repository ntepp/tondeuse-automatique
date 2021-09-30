package pelouse;

import tondeuse.Position;

public class Lawn {
    private int width;
    private int length;

    public Lawn(int width, int length) {
        this.width = width;
        this.length = length;
    }

    public boolean isValidPosition(Position p) {
        return p.getX()>=0 && p.getY()>=0 && p.getX() <= width && p.getY() <= length;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }
}
