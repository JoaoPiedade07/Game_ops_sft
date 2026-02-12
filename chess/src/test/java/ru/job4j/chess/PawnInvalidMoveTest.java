package ru.job4j.chess;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.white.PawnWhite;
import ru.job4j.chess.figures.Figure;

public class PawnInvalidMoveTest {

    private Logic logic;

    @Before
    public void setUp() {
        logic = new Logic();
        logic.clean();
    }


    @Test
    public void whenPawnTriesToMoveBackwards_ShouldFail() {
        System.out.println("\nTest - Movimento inválido - não pode mover para trás");

        Figure pawn = new PawnWhite(Cell.E3);
        logic.add(pawn);

        System.out.println("  Peão em E3 tenta mover para E2 (para TRÁS)");

        try {
            logic.move(Cell.E3, Cell.E2);
            fail("BUG: Peão NÃO deveria poder mover para trás (E3→E2)");
        } catch (ImpossibleMoveException e) {
            System.out.println(" PASSOU: Movimento bloqueado - " +
                    e.getClass().getSimpleName());
            assertTrue("Movimento inválido corretamente rejeitado", true);
        } catch (Exception e) {
            fail("Exceção errada: " + e.getClass().getSimpleName());
        }
    }
}
