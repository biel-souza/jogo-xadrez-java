package src.chess;

import src.chess.pieces.King;
import src.chess.pieces.Rook;
import src.game.Board;
import src.game.Position;

public class ChessMatch {
    private Board board;

    public ChessMatch() {
        board = new Board(8, 8);
        initialSetup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColums()];

        for(int r = 0; r < board.getRows(); r++){
            for(int c = 0; c < board.getColums(); c++){
                mat[r][c] = (ChessPiece) board.piece(r, c);
            }
        }

        return mat;
    }

    private void initialSetup() {
        board.placePiece(new Rook(board, Color.WHITE), new Position(0, 0));
        board.placePiece(new King(board, Color.BLACK), new Position(7, 4));
    }
}