package utils;

import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    private Utils() {
    }

    public static List<String> parseCommand(String command) {
        return command
                .chars()
                .mapToObj(action -> ((char) action)+"")
                .collect(Collectors.toList());
    }
}
