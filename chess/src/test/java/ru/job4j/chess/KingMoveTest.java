package ru.job4j.chess;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.white.KingWhite;
import ru.job4j.chess.figures.Figure;

public class KingMoveTest {

    private Logic logic;

    @Before
    public void setUp() {
        logic = new Logic();
        logic.clean();
    }

    @Test
    public void whenKingMovesOneSquareForwardThenMoveSucceeds() {
        Figure king = new KingWhite(Cell.E1);
        logic.add(king);

        try {
            logic.move(Cell.E1, Cell.E2);
            assertTrue("Rei deveria mover uma casa para a frente", true);
        } catch (Exception e) {
            fail("Movimento do rei falhou: " + e.getMessage());
        }
    }

    @Test
    public void whenKingMovesOneSquareDiagonallyThenMoveSucceeds() {
        Figure king = new KingWhite(Cell.E1);
        logic.add(king);

        try {
            logic.move(Cell.E1, Cell.D2);
            assertTrue("Rei deveria mover uma casa na diagonal", true);
        } catch (Exception e) {
            fail("Movimento diagonal do rei falhou: " + e.getMessage());
        }
    }
}
