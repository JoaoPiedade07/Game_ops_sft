package ru.job4j.chess;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.white.QueenWhite;
import ru.job4j.chess.figures.Figure;

public class QueenMoveTest {

    private Logic logic;

    @Before
    public void setUp() {
        logic = new Logic();
        logic.clean();
    }

    @Test
    public void whenQueenMovesVerticallyThenMoveSucceeds() {
        Figure queen = new QueenWhite(Cell.D1);
        logic.add(queen);

        try {
            logic.move(Cell.D1, Cell.D5);
            assertTrue("Rainha deveria mover na vertical sem exceção", true);
        } catch (Exception e) {
            fail("Movimento vertical da rainha falhou: " + e.getMessage());
        }
    }

    @Test
    public void whenQueenMovesHorizontallyThenMoveSucceeds() {
        Figure queen = new QueenWhite(Cell.D4);
        logic.add(queen);

        try {
            logic.move(Cell.D4, Cell.H4);
            assertTrue("Rainha deveria mover na horizontal", true);
        } catch (Exception e) {
            fail("Movimento horizontal da rainha falhou: " + e.getMessage());
        }
    }
}
