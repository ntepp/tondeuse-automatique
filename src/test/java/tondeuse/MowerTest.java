package tondeuse;

import enumarations.Command;
import enumarations.Orientation;
import org.junit.Assert;
import org.junit.Test;
import pelouse.Lawn;

public class MowerTest {
    public static final int MAX_X = 5;
    public static final int MAX_Y = 5;
    Lawn lawn = new Lawn(MAX_X, MAX_Y);

    @Test
    public void canMove() {
        Position position = new Position(1, 2);
        String orientation = Orientation.NORTH.getValue();
        Mower mower = new Mower(position, orientation, lawn);
        boolean result = mower.canMove();
        Assert.assertEquals("The mower in position (1,2) and orientation N can move", Boolean.TRUE, result);
    }

    @Test
    public void moveNext() {
        Position position = new Position(1, 2);
        String orientation = Orientation.NORTH.getValue();
        Mower mower = new Mower(position, orientation, lawn);
        Position actualPosition = mower.moveNext(position.copy());
        Position expectedPosition = new Position(1, 3);
        Assert.assertEquals("Doit modifier la position actuelle en increment y+1 sans changer d'orientation", expectedPosition, actualPosition);
    }

    @Test
    public void changeOrientation() {
        Position position = new Position(1, 2);
        String orientation = Orientation.NORTH.getValue();
        Mower mower = new Mower(position, orientation, lawn);
        String actualOrientation = mower.changeOrientation(Command.GAUCHE.getValue());
        String expectedPosition = Orientation.WEST.getValue();
        Assert.assertEquals("La tondeuse etant oriente vers le NORD, l'Action GAUCHE oriente la tondeuse vers l'OUEST", expectedPosition, actualOrientation);
    }

    @Test
    public void move() {
        String commands = "AADAADADDA";
        Position position = new Position(3, 3);
        String orientation = Orientation.EAST.getValue();
        Mower actualPosition = new Mower(position, orientation, lawn);
        actualPosition.move(commands);

        Position position2 = new Position(5, 1);
        String orientation2 = Orientation.EAST.getValue();
        Mower expectedPosition = new Mower(position2, orientation2, lawn);

        Assert.assertEquals("Le resultat attendue est 1 3 N", expectedPosition, actualPosition);
    }
}