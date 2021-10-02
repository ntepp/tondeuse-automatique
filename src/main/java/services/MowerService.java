package services;

import pelouse.Lawn;
import tondeuse.Mower;
import utils.FileUtils;
import utils.Utils;

import java.io.IOException;
import java.util.*;

public class MowerService {
    private List<String> input;

    public MowerService() throws IOException {
        input = FileUtils.readFile();
    }

    /* Get lawn size from file */
    public Lawn getLawn() {
        return Utils.parseLawn(input.get(0));
    }

    /* Get mowers with action from file */
    public Map<Mower, String> getMowersWithActions() {
        LinkedHashMap<Mower, String> mowerList = new LinkedHashMap<>();

        for (int i = 1; i < input.size() - 1; i = i + 2) {
            String positionString = input.get(i);
            Mower mower = Utils.parseMower(getLawn(), positionString);
            String commands = input.get(i + 1);
            mowerList.put(mower, commands);
        }
        return mowerList;
    }
}
