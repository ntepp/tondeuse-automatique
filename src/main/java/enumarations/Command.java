package enumarations;

public enum Command {
    DROITE("D"), GAUCHE("G"), AVANCE("A");

    private String value;

    Command(String e) {
        this.value = e;
    }

    public String getValue() {
        return value;
    }
}
