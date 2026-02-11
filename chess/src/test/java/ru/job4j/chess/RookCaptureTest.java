package ru.job4j.chess;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.white.RookWhite;
import ru.job4j.chess.figures.black.PawnBlack;
import ru.job4j.chess.figures.Figure;

public class RookCaptureTest {

    private Logic logic;

    @Before
    public void setUp() {
        logic = new Logic();
        logic.clean();
    }

    @Test
    public void whenRookCapturesBlackPawnRight() {
        // Captura para DIREITA (→)
        Figure rook = new RookWhite(Cell.A1);
        Figure blackPawn = new PawnBlack(Cell.H1);
        logic.add(rook);
        logic.add(blackPawn);

        try {
            logic.move(Cell.A1, Cell.H1);
            Figure movedRook = logic.getFigureAt(Cell.H1);
            assertNotNull("Torre deveria estar em H1", movedRook);
            assertEquals("Torre deveria capturar em H1 (direita)",
                    Cell.H1, movedRook.position());
            assertNull("Peão preto deveria ter sido removido", 
                    logic.getFigureAt(Cell.H1) instanceof PawnBlack ? logic.getFigureAt(Cell.H1) : null);
        } catch (Exception e) {
            fail("Falha na captura para direita: " + e.getMessage());
        }
    }

    @Test
    public void whenRookCapturesBlackPawnLeft() {
        // Captura para ESQUERDA (←)
        Figure rook = new RookWhite(Cell.H1);
        Figure blackPawn = new PawnBlack(Cell.A1);
        logic.add(rook);
        logic.add(blackPawn);

        try {
            logic.move(Cell.H1, Cell.A1);
            Figure movedRook = logic.getFigureAt(Cell.A1);
            assertNotNull("Torre deveria estar em A1", movedRook);
            assertEquals("Torre deveria capturar em A1 (esquerda)",
                    Cell.A1, movedRook.position());
        } catch (Exception e) {
            fail("Falha na captura para esquerda: " + e.getMessage());
        }
    }

    @Test
    public void whenRookCapturesBlackPawnUp() {
        // Captura para CIMA (↑)
        Figure rook = new RookWhite(Cell.A1);
        Figure blackPawn = new PawnBlack(Cell.A8);
        logic.add(rook);
        logic.add(blackPawn);

        try {
            logic.move(Cell.A1, Cell.A8);
            Figure movedRook = logic.getFigureAt(Cell.A8);
            assertNotNull("Torre deveria estar em A8", movedRook);
            assertEquals("Torre deveria capturar em A8 (cima)",
                    Cell.A8, movedRook.position());
        } catch (Exception e) {
            fail("Falha na captura para cima: " + e.getMessage());
        }
    }

    @Test
    public void whenRookCapturesBlackPawnDown() {
        // Captura para BAIXO (↓)
        Figure rook = new RookWhite(Cell.A8);
        Figure blackPawn = new PawnBlack(Cell.A1);
        logic.add(rook);
        logic.add(blackPawn);

        try {
            logic.move(Cell.A8, Cell.A1);
            Figure movedRook = logic.getFigureAt(Cell.A1);
            assertNotNull("Torre deveria estar em A1", movedRook);
            assertEquals("Torre deveria capturar em A1 (baixo)",
                    Cell.A1, movedRook.position());
        } catch (Exception e) {
            fail("Falha na captura para baixo: " + e.getMessage());
        }
    }
}
