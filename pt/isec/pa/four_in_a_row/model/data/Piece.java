package pt.isec.pa.four_in_a_row.model.data;

public enum Piece implements Cloneable{
    YELLOW("Y"), RED("R"), NONE(" ");

    String letter;

    Piece(String letter) {
        this.letter = letter;
    }

    public Piece other() {
        return switch (this) {
            case YELLOW -> RED;
            case RED -> YELLOW;
            default -> NONE;
        };
    }

    @Override
    public String toString() {
        return letter;
    }
}
