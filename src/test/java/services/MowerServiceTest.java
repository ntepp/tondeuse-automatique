package services;

import enumarations.Orientation;
import org.junit.Assert;
import org.junit.Test;
import pelouse.Lawn;
import tondeuse.Mower;
import tondeuse.Position;

import java.io.IOException;
import java.util.Map;

public class MowerServiceTest {

    @Test
    public void getLawn() throws IOException {
        MowerService mowerService = new MowerService();
        Lawn expectedLawn = new Lawn(5, 5);
        Lawn lawn = mowerService.getLawn();
        Assert.assertEquals("La largeur attendue est 5", expectedLawn, lawn);
    }

    @Test
    public void getMower1WithActions() throws IOException {
        MowerService mowerService = new MowerService();
        Lawn lawn = new Lawn(5, 5);
        Position position = new Position(1, 2);
        String orientation = Orientation.NORTH.getValue();
        Mower expectedMower = new Mower(position, orientation, lawn);
        String expectedCommand = "GAGAGAGAA";

        Map<Mower, String> mowersWithActions = mowerService.getMowersWithActions();
        Assert.assertEquals(expectedCommand, mowersWithActions.get(expectedMower));
    }

    @Test
    public void getMower2WithActions() throws IOException {
        MowerService mowerService = new MowerService();
        Lawn lawn = new Lawn(5, 5);
        Position position = new Position(3, 3);
        String orientation = Orientation.EAST.getValue();
        Mower expectedMower = new Mower(position, orientation, lawn);
        String expectedCommand = "AADAADADDA";

        Map<Mower, String> mowersWithActions = mowerService.getMowersWithActions();
        Assert.assertEquals(expectedCommand, mowersWithActions.get(expectedMower));
    }
}