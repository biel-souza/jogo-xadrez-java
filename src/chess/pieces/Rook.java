package src.chess.pieces;

import src.chess.ChessPiece;
import src.chess.Color;
import src.game.Board;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }
}
