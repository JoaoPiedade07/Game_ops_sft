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

            assertEquals("Peão deveria estar em A3 após mover",
                    Cell.A3, pawn.position());

        } catch (Exception e) {
            fail("Movimento válido falhou: " + e.getMessage());
        }
    }


    @Test
    public void whenWhitePawnMovesTwoForwardOnFirstMove() {
        // Peão pode mover 2 casas no PRIMEIRO movimento
        Figure pawn = new PawnWhite(Cell.A2);
        logic.add(pawn);

        try {
            logic.move(Cell.A2, Cell.A4);
            assertEquals("Peão deveria poder mover 2 casas no primeiro movimento",
                    Cell.A4, pawn.position());
        } catch (Exception e) {
            fail("Movimento de 2 casas falhou: " + e.getMessage());
        }
    }

    @Test
    public void whenWhitePawnCannotMoveThreeForward() {
        // Peão NUNCA pode mover 3 casas
        Figure pawn = new PawnWhite(Cell.A2);
        logic.add(pawn);

        try {
            logic.move(Cell.A2, Cell.A5);  // 3 casas - INVÁLIDO!
            fail("Peão não deveria mover 3 casas!");
        } catch (Exception e) {
            // Correto - deveria falhar
            assertTrue("Peão não pode mover 3 casas", true);
        }
    }
}