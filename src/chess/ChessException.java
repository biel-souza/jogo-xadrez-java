package src.chess;

import src.game.BoardException;

public class ChessException extends BoardException {
    public ChessException(String msg) {
        super(msg);
    }
}
