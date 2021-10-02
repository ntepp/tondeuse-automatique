package utils;

import enumarations.Orientation;
import org.junit.Assert;
import org.junit.Test;
import pelouse.Lawn;
import tondeuse.Mower;
import tondeuse.Position;

import java.util.Arrays;
import java.util.List;

public class UtilsTest {

    @Test
    public void parseCommand() {
        List<String> commandList = Utils.parseCommand("AADAADADDA");
        List<String> expectedCommandList = Arrays.asList("A", "A", "D", "A", "A", "D", "A", "D", "D", "A");
        Assert.assertEquals("la liste en sortie doit avoir les memes caracteres dans le meme ordre", expectedCommandList, commandList);
    }

    @Test
    public void parseLawn() {
        Lawn lawn = Utils.parseLawn("5 2");
        Lawn expectedLawn = new Lawn(5, 2);
        Assert.assertEquals(expectedLawn, lawn);
    }

    @Test
    public void parseMower() {
        Lawn lawn = new Lawn(5, 2);
        Mower mower = Utils.parseMower(lawn, "1 2 N");
        Position position = new Position(1, 2);
        Mower expectedMower = new Mower(position, Orientation.NORTH.getValue(), lawn);
        Assert.assertEquals(expectedMower, mower);
    }
}