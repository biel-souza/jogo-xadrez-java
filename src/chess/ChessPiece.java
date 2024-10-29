package src.chess;

import src.game.Board;
import src.game.Piece;
import src.game.Position;

public abstract class ChessPiece extends Piece {
    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    protected boolean isThereOpponentPiece(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);

        return p != null && p.getColor() != color;
    }

    protected boolean canMove(Position position) {
        return getBoard().positionExists(position) &&
                (getBoard().positionExists(position) && getBoard().piece(position) == null || isThereOpponentPiece(position));
    }
}
