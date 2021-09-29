package enumarations;

public enum Orientation {
    NORTH("N"), EAST("E"), WEST("W"), SOUTH("S");

    private String value;

    Orientation(String e) {
        this.value = e;
    }

    public String getValue() {
        return value;
    }
}
