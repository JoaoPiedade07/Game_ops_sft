package ru.job4j.chess;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.white.PawnWhite;

public class DebugPawnTest {
    public static void main(String[] args) {
        System.out.println("🔍 DEBUG PEÃO BRANCO\n");
        
        PawnWhite pawn = new PawnWhite(Cell.E2);
        System.out.println("Peão criado em: " + pawn.position());
        System.out.println("  getX() = " + pawn.position().getX());
        System.out.println("  getY() = " + pawn.position().getY());
        
        System.out.println("\nTentando mover E2 → E3:");
        try {
            Cell[] steps = pawn.way(Cell.E3);
            System.out.println("  way(E3) = " + java.util.Arrays.toString(steps));
        } catch (Exception e) {
            System.out.println("  ERRO: " + e.getMessage());
        }
    }
}
