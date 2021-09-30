package services;

import enumarations.Orientation;
import org.junit.jupiter.api.Test;
import pelouse.Lawn;
import tondeuse.Mower;
import tondeuse.Position;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MowerManagerTest {
    public static final int MAX_X = 5;
    public static final int MAX_Y = 5;
    Lawn lawn = new Lawn(MAX_X,MAX_Y);

    @Test
    void run() throws IOException {
        MowerService mowerService = new MowerService();


        Position position1 = new Position(1,3);
        String orientation1 = Orientation.NORTH.getValue();
        Mower expectedMower1 = new Mower(position1,orientation1,lawn);

        Position position2 = new Position(5,1);
        String orientation2 = Orientation.EAST.getValue();
        Mower expectedMower2 = new Mower(position2,orientation2,lawn);

        Map<Mower, String> mowersWithActions = mowerService.getMowersWithActions();

        Iterator<Mower> mowerIterator = mowersWithActions.keySet().stream().iterator();
        Iterator<String> commandIterator = mowersWithActions.values().stream().iterator();
        Mower mower1 = mowerIterator.next();
        String command1 = commandIterator.next();
        Mower mower2 = mowerIterator.next();
        String command2 = commandIterator.next();

        mower1.move(command1);
        mower2.move(command2);

        assertEquals(expectedMower1, mower1, "Le resultat attendue est 1 3 N");
        assertEquals(expectedMower2, mower2, "Le resultat attendue est 5 1 E");
    }
}
