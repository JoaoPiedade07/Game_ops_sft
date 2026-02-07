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
    public void whenRookCapturesBlackPawnHorizontally() {
        Figure rook = new RookWhite(Cell.A1);
        Figure blackPawn = new PawnBlack(Cell.H1);
        logic.add(rook);
        logic.add(blackPawn);
        
        try {
            logic.move(Cell.A1, Cell.H1);
            assertTrue(true);
        } catch (Exception e) {
            fail("Não deveria lançar exceção: " + e.getMessage());
        }
    }
}
