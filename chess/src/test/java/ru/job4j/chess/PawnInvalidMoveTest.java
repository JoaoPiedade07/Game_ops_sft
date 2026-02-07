package ru.job4j.chess;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.white.PawnWhite;
import ru.job4j.chess.figures.Figure;

public class PawnInvalidMoveTest {
    
    private Logic logic;
    
    @Before
    public void setUp() {
        logic = new Logic();
        logic.clean();
    }
    
    @Test
    public void whenPawnTriesToMoveBackwardsThenShouldThrowException() {
        Figure pawn = new PawnWhite(Cell.A3);
        logic.add(pawn);
        
        try {
            logic.move(Cell.A3, Cell.A2);
            fail("Deveria lançar exceção ao mover peão para trás");
        } catch (Exception e) {
            assertTrue(e instanceof ImpossibleMoveException || 
                      e instanceof RuntimeException);
        }
    }
}
