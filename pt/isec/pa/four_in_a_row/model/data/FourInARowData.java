package pt.isec.pa.four_in_a_row.model.data;

import pt.isec.pa.four_in_a_row.model.memento.IMemento;
import pt.isec.pa.four_in_a_row.model.memento.IOriginator;

import java.util.Arrays;

public class FourInARowData implements Cloneable, IOriginator {
    private static final int HEIGHT = 6;
    private static final int WIDTH = 7;
    private static final int SEQUENCE = 4;

    Piece[][] board;
    Piece currentPlayer;

    public FourInARowData() {
        init();
    }

    private static class MyMemento implements IMemento {
        private Piece[][] board;
        private Piece currentPlayer;
        MyMemento(FourInARowData base) {
            this.board = new Piece[base.board.length][];
            for(int i = 0; i < base.board.length; i++)
                this.board[i] = Arrays.copyOf(base.board[i], base.board[i].length);

            this.currentPlayer = base.currentPlayer;
        }
    }

    @Override
    public IMemento save() { return new MyMemento(this); }
    @Override
    public void restore(IMemento memento) {
        if (memento instanceof MyMemento m) {
            board = m.board;
            currentPlayer = m.currentPlayer;
        }
    }

    public void init() {
        board = new Piece[HEIGHT][WIDTH];
        for (int y = 0; y < HEIGHT; y++)
            for (int x = 0; x < WIDTH; x++)
                board[y][x] = Piece.NONE;
        currentPlayer = Math.random() < 0.5 ? Piece.YELLOW : Piece.RED;
    }

    public Piece getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean play(int column) {
        if (column < 0 || column >= WIDTH)
            return false;
        for (int y = HEIGHT - 1; y >= 0; y--)
            if (board[y][column] == Piece.NONE) {
                board[y][column] = currentPlayer;
                currentPlayer = currentPlayer.other();
                return true;
            }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < HEIGHT; y++) {
            sb.append("+---".repeat(WIDTH)).append("+\n");
            for (int x = 0; x < WIDTH; x++)
                sb.append("| ").append(board[y][x]).append(" ");
            sb.append("|\n");
        }
        sb.append("+---".repeat(WIDTH)).append("+");
        return sb.toString();
    }
    public boolean isFull() {
        for(int x=0;x<WIDTH;x++)
            if (board[0][x] == Piece.NONE)
                return false;
        return true;
    }

    public Piece checkWinner() {
        for (int y = 0; y < HEIGHT; y++)
            for (int x = 0; x < WIDTH; x++) {
                Piece p = board[y][x];
                if (p != Piece.NONE)
                    for (Direction d : Direction.values())
                        if (1+checkDirection(y + d.dy, x + d.dx, d, p) >= SEQUENCE)
                            return p;
            }
        return Piece.NONE;
    }

    private int checkDirection(int y, int x, Direction d, Piece p) {
        if (x < 0 || x >= WIDTH || y < 0 || y >= HEIGHT || board[y][x] != p)
            return 0;
        return 1 + checkDirection(y + d.dy, x + d.dx, d, p);
    }

    @Override
    public FourInARowData clone() {
        try {
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return (FourInARowData) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    private enum Direction {
        n(-1, 0), s(1, 0), e(0, 1), w(0, -1),
        nw(-1, -1), ne(-1, 1), se(1, 1), sw(1, -1);
        int dy, dx;

        Direction(int dy, int dx) {
            this.dy = dy;
            this.dx = dx;
        }
    }

}
