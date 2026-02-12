package ru.job4j.chess;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.white.KingWhite;

public class KingMoveTest {

    private Logic logic;

    @Before
    public void setUp() {
        logic = new Logic();
        logic.clean();
    }

    @Test
    public void whenKingMovesOneSquareForwardThenMoveSucceeds() throws Exception {
        logic.add(new KingWhite(Cell.E1));

        logic.move(Cell.E1, Cell.E2);
        assertNotNull("Rei deveria estar em E2", logic.getFigureAt(Cell.E2));
        assertEquals("Rei deveria estar em E2", Cell.E2, logic.getFigureAt(Cell.E2).position());
    }

    @Test
    public void whenKingMovesOneSquareDiagonallyThenMoveSucceeds() throws Exception {
        logic.add(new KingWhite(Cell.E1));

        logic.move(Cell.E1, Cell.D2);
        assertNotNull("Rei deveria estar em D2", logic.getFigureAt(Cell.D2));
        assertEquals("Rei deveria estar em D2", Cell.D2, logic.getFigureAt(Cell.D2).position());
    }
}
