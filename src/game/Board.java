package src.game;

public class Board {
    private int rows;
    private int colums;
    private Piece[][] pieces;

    public Board(int rows, int colums) {
        this.rows = rows;
        this.colums = colums;
        pieces = new Piece[rows][colums];
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColums() {
        return colums;
    }

    public void setColums(int colums) {
        this.colums = colums;
    }

    public Piece piece(int row, int colum) {
        return pieces[row][colum];
    }

    public Piece piece(Position position) {
        return pieces[position.getRow()][position.getColumn()];
    }
}
