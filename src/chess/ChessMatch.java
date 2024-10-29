package src.chess;

import src.chess.pieces.King;
import src.chess.pieces.Rook;
import src.game.Board;
import src.game.Piece;
import src.game.Position;

public class ChessMatch {
    private Board board;
    private Color currentPlayer;
    private int turn;

    public ChessMatch() {
        board = new Board(8, 8);
        turn = 1;
        currentPlayer = Color.WHITE;
        initialSetup();
    }

    public Color getCurrentPlayer() {
        return currentPlayer;
    }

    public int getTurn() {
        return turn;
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

    public boolean[][] possibleMoves(ChessPosition source) {
        Position p = source.toPosition();

        validateSourcePosition(source.toPosition());

        return board.piece(p).possibleMoves();
    }

    public ChessPiece performeChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();

        validateSourcePosition(source);
        validateTargetPosition(source, target);

        Piece capturedPiece = makeMove(source, target);
        nextTurn();

        return (ChessPiece) capturedPiece;
    }

    private Piece makeMove(Position source, Position target) {
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);

        return capturedPiece;
    }

    private void nextTurn() {
        turn ++;
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private void validateSourcePosition(Position position) {
        if(!board.thereIsAPiece(position)) {
            throw new ChessException("Não há peça na posição de origem");
        }
        if(!board.piece(position).isThereAnyPossibleMove()) {
            throw new ChessException("Não há movimentos possiveis para essa peça");
        }
        if(((ChessPiece)board.piece(position)).getColor() != currentPlayer) {
            throw new ChessException("A peça escolhida não é sua");
        }
    }

    private void validateTargetPosition(Position source, Position target) {
        if(!board.piece(source).possibleMove(target)) {
            throw new ChessException("Essa peça não pode se mover para posição de destino");
        }
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    private void initialSetup() {
        placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
    }
}
