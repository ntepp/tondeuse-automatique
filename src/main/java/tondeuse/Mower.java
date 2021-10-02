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
        if (Orientation.NORTH.getValue().equals(this.orientation)) {
            p.moveUp();
        } else if (Orientation.WEST.getValue().equals(this.orientation)) {
            p.moveLeft();
        } else if (Orientation.EAST.getValue().equals(this.orientation)) {
            p.moveRight();
        } else if (Orientation.SOUTH.getValue().equals(this.orientation)) {
            p.moveDown();
        }

        return p;
    }

    public String changeOrientation(String command) {
        if (Command.DROITE.getValue().equals(command)) {
            if (Orientation.NORTH.getValue().equals(this.orientation)) {
                this.orientation = Orientation.EAST.getValue();
            } else if (Orientation.EAST.getValue().equals(this.orientation)) {
                this.orientation = Orientation.SOUTH.getValue();
            } else if (Orientation.SOUTH.getValue().equals(this.orientation)) {
                this.orientation = Orientation.WEST.getValue();
            } else if (Orientation.WEST.getValue().equals(this.orientation)) {
                this.orientation = Orientation.NORTH.getValue();
            }
        } else if (Command.GAUCHE.getValue().equals(command)) {
            if (Orientation.NORTH.getValue().equals(this.orientation)) {
                this.orientation = Orientation.WEST.getValue();
            } else if (Orientation.WEST.getValue().equals(this.orientation)) {
                this.orientation = Orientation.SOUTH.getValue();
            } else if (Orientation.SOUTH.getValue().equals(this.orientation)) {
                this.orientation = Orientation.EAST.getValue();
            } else if (Orientation.EAST.getValue().equals(this.orientation)) {
                this.orientation = Orientation.NORTH.getValue();
            }

        }
        return orientation;
    }

    public void move(String commands) {
        for (String command : Utils.parseCommand(commands)) {
            Action action = new Action(command);
            if (action.isMove() && canMove()) {
                moveNext(position);
            } else {
                changeOrientation(command);
            }
        }
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
