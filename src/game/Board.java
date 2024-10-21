package src.game;

public class Board {
    private int rows;
    private int colums;
    private Piece[][] pieces;

    public Board(int rows, int colums) {
        if(rows < 1 || colums < 1) {
            throw new BoardException("Erro ao criar tabuleiro: Precisa ter pelo menos 1 coluna e 1 linha");
        }


        this.rows = rows;
        this.colums = colums;
        pieces = new Piece[rows][colums];
    }

    public int getRows() {
        return rows;
    }

    public int getColums() {
        return colums;
    }

    public Piece piece(int row, int column) {
        if(!positionExists(row, column)) {
            throw new BoardException("Posição não existe no tabuleiro!");
        }

        return pieces[row][column];
    }

    public Piece piece(Position position) {
        return piece(position.getRow(), position.getColumn());
    }

    public void placePiece(Piece piece, Position position) {
        if(thereIsAPiece(position)) {
            throw new BoardException("Posição informada já esta sendo utilizada!" + position);
        }

        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public Boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < colums;
    }

    public Boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    public Boolean thereIsAPiece(Position position) {
        if(!positionExists(position)) {
            throw new BoardException("Posição não existe no tabuleiro!");
        }

        return piece(position) != null;
    }
}
