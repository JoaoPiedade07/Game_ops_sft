package ru.job4j.chess;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.white.BishopWhite;
import ru.job4j.chess.figures.Figure;

public class BishopValidMoveTest {

    private Logic logic;

    @Before
    public void setUp() {
        logic = new Logic();
        logic.clean();
    }

    @Test
    public void whenBishopMovesDiagonallyThenMoveSucceeds() {
        Figure bishop = new BishopWhite(Cell.C1);
        logic.add(bishop);

        try {
            logic.move(Cell.C1, Cell.G5);
            assertTrue("Bispo deveria mover na diagonal sem exceção", true);
        } catch (Exception e) {
            fail("Movimento diagonal do bispo falhou: " + e.getMessage());
        }
    }

    @Test
    public void whenBishopMovesToDifferentDiagonalThenMoveSucceeds() {
        Figure bishop = new BishopWhite(Cell.F1);
        logic.add(bishop);

        try {
            logic.move(Cell.F1, Cell.A6);
            assertTrue("Bispo deveria mover na diagonal", true);
        } catch (Exception e) {
            fail("Movimento diagonal do bispo falhou: " + e.getMessage());
        }
    }
}
