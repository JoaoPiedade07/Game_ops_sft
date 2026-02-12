package ru.job4j.chess;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.white.PawnWhite;
import ru.job4j.chess.figures.Figure;

public class PawnWhiteMoveTest {

    private Logic logic;

    @Before
    public void setUp() {
        logic = new Logic();
        logic.clean();
    }

    @Test
    public void whenWhitePawnMovesOneForwardToEmptyCellThenMoveIsValid() {
        Figure pawn = new PawnWhite(Cell.A2);
        logic.add(pawn);

        try {
            logic.move(Cell.A2, Cell.A3);
            
            Figure movedPawn = logic.getFigureAt(Cell.A3);
            assertNotNull("Peão deveria estar em A3", movedPawn);
            assertEquals("Peão deveria estar em A3 após mover",
                    Cell.A3, movedPawn.position());
            
            assertNull("Posição original deveria estar vazia", 
                    logic.getFigureAt(Cell.A2));

        } catch (Exception e) {
            fail("Movimento válido falhou: " + e.getMessage());
        }
    }

    @Test
    public void whenWhitePawnMovesTwoForwardOnFirstMove() {
        Figure pawn = new PawnWhite(Cell.A2);
        logic.add(pawn);

        try {
            logic.move(Cell.A2, Cell.A4);
            
            Figure movedPawn = logic.getFigureAt(Cell.A4);
            assertNotNull("Peão deveria estar em A4", movedPawn);
            assertEquals("Peão deveria poder mover 2 casas no primeiro movimento",
                    Cell.A4, movedPawn.position());

        } catch (Exception e) {
            fail("Movimento de 2 casas falhou: " + e.getMessage());
        }
    }

    @Test
    public void whenWhitePawnCannotMoveThreeForward() {
        Figure pawn = new PawnWhite(Cell.A2);
        logic.add(pawn);

        try {
            logic.move(Cell.A2, Cell.A5);
            fail("Peão não deveria mover 3 casas!");
        } catch (ImpossibleMoveException e) {
            assertTrue("Peão não pode mover 3 casas", true);
        } catch (Exception e) {
            fail("Exceção errada: " + e.getClass().getSimpleName());
        }
    }
}
