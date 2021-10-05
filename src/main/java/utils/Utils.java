package utils;

import pelouse.Lawn;
import tondeuse.Mower;
import tondeuse.Position;

import java.util.List;
import java.util.stream.Collectors;

public interface Utils {

    String SEPARATOR = " ";


    static List<String> parseCommand(String command) {
        return command
                .chars()
                .mapToObj(action -> ((char) action) + "")
                .collect(Collectors.toList());
    }

    static Lawn parseLawn(String input) {
        return new Lawn(Integer.parseInt(input.split(SEPARATOR)[0]), Integer.parseInt(input.split(SEPARATOR)[1]));
    }

    static Mower parseMower(Lawn lawn, String input) {
        String[] data = input.split(SEPARATOR);
        int x = Integer.parseInt(data[0]);
        int y = Integer.parseInt(data[1]);
        String orientation = data[2];
        Position position = new Position(x, y);
        return new Mower(position, orientation, lawn);
    }
}
