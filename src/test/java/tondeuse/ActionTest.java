package tondeuse;


import org.junit.Assert;
import org.junit.Test;

public class ActionTest {

    @Test
    public void testTestGetName() {
        Action action1 = new Action("A");
        Action action2 = new Action("G");
        Action action3 = new Action("D");
        String expected = "A";
        Assert.assertEquals(expected, action1.getName());
        expected = "G";
        Assert.assertEquals(expected, action2.getName());
        expected = "D";
        Assert.assertEquals(expected, action3.getName());
    }

    @Test
    public void testIsMove() {
        Action action1 = new Action("A");
        Assert.assertTrue(action1.isMove());
    }

    @Test
    public void testIsOrientation() {
        Action action1 = new Action("D");
        Assert.assertTrue(action1.isOrientation());
    }
}