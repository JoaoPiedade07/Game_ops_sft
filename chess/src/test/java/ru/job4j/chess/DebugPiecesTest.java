package ru.job4j.chess;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.white.*;
import java.util.Arrays;

public class DebugPiecesTest {
    public static void main(String[] args) {
        System.out.println("🔍 DEBUG DAS PEÇAS\n");
        
        // Testar Peão
        Figure pawn = new PawnWhite(Cell.A2);
        System.out.println("Peão A2 → A3:");
        try {
            Cell[] steps = pawn.way(Cell.A3);
            System.out.println("  way(A3) = " + Arrays.toString(steps));
        } catch (Exception e) {
            System.out.println("  ERRO: " + e.getMessage());
        }
        
        // Testar Torre
        Figure rook = new RookWhite(Cell.A1);
        System.out.println("\nTorre A1 → A8:");
        try {
            Cell[] steps = rook.way(Cell.A8);
            System.out.println("  way(A8) = " + Arrays.toString(steps));
        } catch (Exception e) {
            System.out.println("  ERRO: " + e.getMessage());
        }
        
        // Testar Cavalo
        Figure knight = new KnightWhite(Cell.B1);
        System.out.println("\nCavalo B1 → C3:");
        try {
            Cell[] steps = knight.way(Cell.C3);
            System.out.println("  way(C3) = " + Arrays.toString(steps));
        } catch (Exception e) {
            System.out.println("  ERRO: " + e.getMessage());
        }
        
        // Testar Bispo
        Figure bishop = new BishopWhite(Cell.C1);
        System.out.println("\nBispo C1 → E3:");
        try {
            Cell[] steps = bishop.way(Cell.E3);
            System.out.println("  way(E3) = " + Arrays.toString(steps));
        } catch (Exception e) {
            System.out.println("  ERRO: " + e.getMessage());
        }
    }
}
