package src.application;

import src.chess.ChessPiece;
import src.chess.ChessPosition;
import src.chess.Color;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";

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

    public static void printBoard(ChessPiece[][] pieces) {

        for(int i = 0; i < pieces.length; i ++) {
            System.out.print((8 - i) + " ");
            for(int j = 0; j < pieces.length; j ++) {
                printPiece(pieces[i][j]);
            }
            System.out.println();
        }
        System.out.println("  A B C D E F G H");
    }

    private static void printPiece(ChessPiece piece) {
        if (piece == null) {
            System.out.print("-");
        }
        else {
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_RED + piece + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_BLUE + piece + ANSI_RESET);
            }
        }
        System.out.print(" ");
    }
}
