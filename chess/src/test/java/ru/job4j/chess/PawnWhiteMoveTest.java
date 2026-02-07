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
            assertTrue("Movimento deve ser bem-sucedido", true);
        } catch (Exception e) {
            fail("Não deveria lançar exceção: " + e.getMessage());
        }
    }
}