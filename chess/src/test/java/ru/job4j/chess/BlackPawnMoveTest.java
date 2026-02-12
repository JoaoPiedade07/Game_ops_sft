package ru.job4j.chess;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.black.PawnBlack;

public class BlackPawnMoveTest {

    private Logic logic;

    @Before
    public void setUp() {
        logic = new Logic();
        logic.clean();
    }

    @Test
    public void whenBlackPawnMovesOneForwardThenMoveSucceeds() throws Exception {
        logic.add(new PawnBlack(Cell.E7));

        logic.move(Cell.E7, Cell.E6);
        assertNotNull("Peão preto deveria estar em E6", logic.getFigureAt(Cell.E6));
        assertEquals("Peão preto deveria estar em E6", Cell.E6, logic.getFigureAt(Cell.E6).position());
    }

    @Test
    public void whenBlackPawnMovesTwoOnFirstMoveThenMoveSucceeds() throws Exception {
        logic.add(new PawnBlack(Cell.D7));

        logic.move(Cell.D7, Cell.D5);
        assertNotNull("Peão preto deveria estar em D5", logic.getFigureAt(Cell.D5));
        assertEquals("Peão preto deveria estar em D5", Cell.D5, logic.getFigureAt(Cell.D5).position());
    }
}
