package ru.job4j.chess;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.white.QueenWhite;

public class QueenMoveTest {

    private Logic logic;

    @Before
    public void setUp() {
        logic = new Logic();
        logic.clean();
    }

    @Test
    public void whenQueenMovesVerticallyThenMoveSucceeds() throws Exception {
        logic.add(new QueenWhite(Cell.D1));

        logic.move(Cell.D1, Cell.D5);
        assertNotNull("Rainha deveria estar em D5", logic.getFigureAt(Cell.D5));
        assertEquals("Rainha deveria estar em D5", Cell.D5, logic.getFigureAt(Cell.D5).position());
    }

    @Test
    public void whenQueenMovesHorizontallyThenMoveSucceeds() throws Exception {
        logic.add(new QueenWhite(Cell.D4));

        logic.move(Cell.D4, Cell.H4);
        assertNotNull("Rainha deveria estar em H4", logic.getFigureAt(Cell.H4));
        assertEquals("Rainha deveria estar em H4", Cell.H4, logic.getFigureAt(Cell.H4).position());
    }
}
