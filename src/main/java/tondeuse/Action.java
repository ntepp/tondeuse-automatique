package tondeuse;

import enumarations.Command;

public class Action {
    private String name;

    public Action(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isMove() {
        return Command.AVANCE.getValue().equals(name);
    }

    public boolean isOrientation() {
        return !isMove();
    }
}
