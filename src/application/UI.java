package src.application;

import src.chess.ChessMatch;
import src.chess.ChessPiece;
import src.chess.ChessPosition;
import src.chess.Color;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";

    public static ChessPosition readChessPosition(Scanner sc) {
        try {
            String s = sc.nextLine();
            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));

            return new ChessPosition(column, row);
        } catch (RuntimeException e) {
            throw new InputMismatchException("Erro ao ler posição");
        }
    }

    public static void printMatch(ChessMatch chessMatch) {
        printBoard(chessMatch.getPieces());
        System.out.println();
        System.out.println("Rodada : " + chessMatch.getTurn());
        System.out.println("Esperando Jogador: " + chessMatch.getCurrentPlayer());
    }

    public static void printBoard(ChessPiece[][] pieces) {

        for(int i = 0; i < pieces.length; i ++) {
            System.out.print((8 - i) + " ");
            for(int j = 0; j < pieces.length; j ++) {
                printPiece(pieces[i][j], false);
            }
            System.out.println();
        }
        System.out.println("  A B C D E F G H");
    }

    public static void printBoard(ChessPiece[][] pieces, boolean[][] posibleMoves) {

        for(int i = 0; i < pieces.length; i ++) {
            System.out.print((8 - i) + " ");
            for(int j = 0; j < pieces.length; j ++) {
                printPiece(pieces[i][j], posibleMoves[i][j]);
            }
            System.out.println();
        }
        System.out.println("  A B C D E F G H");
    }

    private static void printPiece(ChessPiece piece, boolean background) {
        if(background) {
            System.out.print(ANSI_CYAN_BACKGROUND);
        }

        if (piece == null) {
            System.out.print("-" + ANSI_RESET);
        }
        else {
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_RED + piece + ANSI_RESET);
            }
        }
        System.out.print(" ");
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
