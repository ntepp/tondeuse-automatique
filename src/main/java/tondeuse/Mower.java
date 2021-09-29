package tondeuse;

import enumarations.Command;
import enumarations.Orientation;
import pelouse.Lawn;
import utils.Utils;
import java.util.Objects;

public class Mower {
    private Position position;
    private String orientation;
    private Lawn lawn;

    public Mower(Position position, String orientation, Lawn lawn) {
        this.position = position;
        this.orientation = orientation;
        this.lawn = lawn;
    }

    public boolean canMove() {
        Position newPosition = this.position.copy();
        return lawn.isValidPosition(newPosition);
    }

    public Position moveNext(Position p) {
        return new Position(0,0);
    }

    public String changeOrientation(String command) {
        return this.orientation;
    }

    public void move(String commands){
        return;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mower)) return false;
        Mower mower = (Mower) o;
        return position.equals(mower.position) && orientation.equals(mower.orientation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, orientation);
    }
}
