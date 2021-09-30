package services;

import pelouse.Lawn;
import tondeuse.Mower;
import tondeuse.Position;
import utils.FileUtils;

import java.io.IOException;
import java.util.*;

public class MowerService {
    private List<String> input;

    public MowerService() throws IOException {
        input = FileUtils.readFile();
    }

    public Lawn getLawn(){
        return new Lawn(Integer.parseInt(input.get(0).split(" ")[0]), Integer.parseInt(input.get(0).split(" ")[0]));
    }

    public Map<Mower, String> getMowersWithActions() {
        LinkedHashMap<Mower, String> mowerList = new LinkedHashMap<>();
        for (int i = 1; i < input.size() - 1; i=i+2) {
            String positionString = input.get(i);
            int x = Integer.parseInt(positionString.split(" ")[0]);
            int y = Integer.parseInt(positionString.split(" ")[1]);
            String orientation = positionString.split(" ")[2];
            Position position = new Position(x, y);
            String commands = input.get(i+1);
            mowerList.put(new Mower(position, orientation, getLawn()), commands);
        }
        return mowerList;
    }
}
