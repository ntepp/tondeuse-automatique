package utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void parseCommand() {
        List<String> commandList = Utils.parseCommand("AADAADADDA");
        List<String> expectedCommandList = new ArrayList<>(Arrays.asList("A", "A", "D", "A", "A", "D", "A", "D", "D", "A"));
        assertEquals(expectedCommandList, commandList, "la liste en sortie doit avoir les memes caracteres dans le meme ordre");
    }
}