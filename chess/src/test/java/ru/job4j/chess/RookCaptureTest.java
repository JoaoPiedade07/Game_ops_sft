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
}
