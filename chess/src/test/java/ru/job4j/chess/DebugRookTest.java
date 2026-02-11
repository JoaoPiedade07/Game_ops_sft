package ru.job4j.chess;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.white.RookWhite;

public class DebugRookTest {
    public static void main(String[] args) {
        System.out.println("🔍 DEBUG TORRE BRANCA\n");
        
        RookWhite rook = new RookWhite(Cell.A1);
        System.out.println("Torre criada em: " + rook.position());
        System.out.println("  getX() = " + rook.position().getX());
        System.out.println("  getY() = " + rook.position().getY());
        
        System.out.println("\nTentando mover A1 → A8 (cima):");
        try {
            Cell[] steps = rook.way(Cell.A8);
            System.out.println("  way(A8) = " + java.util.Arrays.toString(steps));
        } catch (Exception e) {
            System.out.println("  ERRO: " + e.getMessage());
        }
        
        System.out.println("\nTentando mover A1 → H1 (direita):");
        try {
            Cell[] steps = rook.way(Cell.H1);
            System.out.println("  way(H1) = " + java.util.Arrays.toString(steps));
        } catch (Exception e) {
            System.out.println("  ERRO: " + e.getMessage());
        }
    }
}
