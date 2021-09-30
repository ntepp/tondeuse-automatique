package services;

import enumarations.Orientation;
import org.junit.jupiter.api.Test;
import pelouse.Lawn;
import tondeuse.Mower;
import tondeuse.Position;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MowerServiceTest {
    MowerService mowerService = new MowerService();

    MowerServiceTest() throws IOException {
    }

    @Test
    void getLawn() {
        Lawn lawn = new Lawn(5, 5);
        Lawn expectedLawn = mowerService.getLawn();
        assertEquals(expectedLawn.getWidth(), lawn.getWidth(), "La largeur attendue est 5");
        assertEquals(expectedLawn.getLength(), lawn.getLength(), "La longueur attendue est 5");
    }

    @Test
    void getMower1WithActions() {
        Lawn lawn = new Lawn(5, 5);
        Position position = new Position(1,2);
        String orientation = Orientation.NORTH.getValue();
        Mower expectedMower = new Mower(position,orientation,lawn);
        String expectedCommand = "GAGAGAGAA";

        Map<Mower, String> mowersWithActions = mowerService.getMowersWithActions();
        assertEquals(expectedCommand, mowersWithActions.get(expectedMower));
    }

    @Test
    void getMower2WithActions() {
        Lawn lawn = new Lawn(5, 5);
        Position position = new Position(3,3);
        String orientation = Orientation.EAST.getValue();
        Mower expectedMower = new Mower(position,orientation,lawn);
        String expectedCommand = "AADAADADDA";

        Map<Mower, String> mowersWithActions = mowerService.getMowersWithActions();
        assertEquals(expectedCommand, mowersWithActions.get(expectedMower));
    }
}