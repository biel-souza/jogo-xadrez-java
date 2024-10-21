package src.chess.pieces;

import src.chess.ChessPiece;
import src.chess.Color;
import src.game.Board;

public class King  extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "♚";
    }
}
