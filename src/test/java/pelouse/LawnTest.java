package pelouse;

import org.junit.Assert;
import org.junit.Test;
import tondeuse.Position;

public class LawnTest {

    @Test
    public void testIsValidPosition() {
        Lawn lawn = new Lawn(5, 5);
        Position position1 = new Position(2, 2);
        Position position2 = new Position(0, 6);

        Assert.assertTrue(lawn.isValidPosition(position1));
        Assert.assertFalse(lawn.isValidPosition(position2));
    }
}