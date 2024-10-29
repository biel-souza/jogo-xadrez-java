package src.chess.pieces;

import src.chess.ChessPiece;
import src.chess.Color;
import src.game.Board;
import src.game.Position;

public class King  extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }


    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColums()];

        Position p = new Position(position.getRow(), position.getColumn());

        for(int i = -1; i < 2; i ++) {
            for(int j = -1; j < 2; j ++) {
                p.setValues(position.getRow() + i, position.getColumn() + j);
                if (canMove(p)) {
                    mat[p.getRow()][p.getColumn()] = true;
                }
            }
        }

        return mat;
    }
}
