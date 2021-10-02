package utils;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtilsTest {

    @Test
    public void readFile() throws IOException {
        List<String> unexpected = new ArrayList<>();
        List<String> expected = Arrays.asList("5 5", "1 2 N", "GAGAGAGAA", "3 3 E", "AADAADADDA");
        Assert.assertNotEquals("Le contenu du fichier en entree ne peut etre vide", unexpected, FileUtils.readFile());
        Assert.assertEquals("donnees en entrees 5 5 1 2 N GAGAGAGAA 3 3 E AADAADADDA", expected, FileUtils.readFile());
    }
}