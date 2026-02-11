package ru.job4j.chess;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.black.PawnBlack;
import ru.job4j.chess.figures.Figure;

public class BlackPawnMoveTest {

    private Logic logic;

    @Before
    public void setUp() {
        logic = new Logic();
        logic.clean();
    }

    @Test
    public void whenBlackPawnMovesOneForwardThenMoveSucceeds() {
        Figure pawn = new PawnBlack(Cell.E7);
        logic.add(pawn);

        try {
            logic.move(Cell.E7, Cell.E6);
            assertTrue("Peão preto deveria mover uma casa para a frente", true);
        } catch (Exception e) {
            fail("Movimento do peão preto falhou: " + e.getMessage());
        }
    }

    @Test
    public void whenBlackPawnMovesTwoOnFirstMoveThenMoveSucceeds() {
        Figure pawn = new PawnBlack(Cell.D7);
        logic.add(pawn);

        try {
            logic.move(Cell.D7, Cell.D5);
            assertTrue("Peão preto deveria mover 2 casas no primeiro movimento", true);
        } catch (Exception e) {
            fail("Movimento de 2 casas do peão preto falhou: " + e.getMessage());
        }
    }
}
