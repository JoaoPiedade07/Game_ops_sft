package ru.job4j.chess;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.white.BishopWhite;

public class BishopValidMoveTest {

    private Logic logic;

    @Before
    public void setUp() {
        logic = new Logic();
        logic.clean();
    }

    @Test
    public void whenBishopMovesDiagonallyThenMoveSucceeds() throws Exception {
        logic.add(new BishopWhite(Cell.C1));

        logic.move(Cell.C1, Cell.G5);
        assertNotNull("Bispo deveria estar em G5", logic.getFigureAt(Cell.G5));
        assertEquals("Bispo deveria estar em G5", Cell.G5, logic.getFigureAt(Cell.G5).position());
    }

}
