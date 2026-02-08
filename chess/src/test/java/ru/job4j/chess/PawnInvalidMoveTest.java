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
    public void whenPawnMovesOneSquareForward_ThenPositionUpdates() {
        System.out.println("🎯 TESTE 1: Movimento básico válido");

        Figure pawn = new PawnWhite(Cell.E2);
        logic.add(pawn);

        System.out.println("  Peão criado em: " + pawn.position());

        try {
            logic.move(Cell.E2, Cell.E3);

            assertEquals("Após mover E2→E3, peão deveria estar em E3",
                    Cell.E3, pawn.position());

            System.out.println("  ✅ PASSOU: Peão moveu corretamente para E3");

        } catch (Exception e) {
            fail("❌ Movimento válido falhou: " + e.getMessage());
        }
    }

    @Test
    public void whenPawnMovesTwoSquaresOnFirstMove_ThenPositionUpdates() {
        System.out.println("\n🎯 TESTE 2: Movimento especial - 2 casas no primeiro movimento");

        Figure pawn = new PawnWhite(Cell.D2);
        logic.add(pawn);

        System.out.println("  Peão branco em D2 (primeira vez que se move)");

        try {
            logic.move(Cell.D2, Cell.D4);

            assertEquals("Peão deveria poder mover 2 casas no primeiro movimento",
                    Cell.D4, pawn.position());

            System.out.println("  ✅ PASSOU: Peão saltou 2 casas para D4");

        } catch (Exception e) {
            fail("❌ Movimento especial falhou: " + e.getMessage());
        }
    }

    @Test
    public void whenPawnTriesToMoveBackwards_ShouldFail() {
        System.out.println("\n🎯 TESTE 3: Movimento inválido - não pode mover para trás");

        Figure pawn = new PawnWhite(Cell.E3);
        logic.add(pawn);

        System.out.println("  Peão em E3 tenta mover para E2 (para TRÁS)");

        try {
            logic.move(Cell.E3, Cell.E2);

            System.out.println("  ❌ ALERTA: Peão moveu para trás!");
            fail("❌ BUG: Peão NÃO deveria poder mover para trás (E3→E2)");

        } catch (Exception e) {
            System.out.println("  ✅ PASSOU: Movimento bloqueado - " +
                    e.getClass().getSimpleName());
            assertTrue("Movimento inválido corretamente rejeitado", true);
        }
    }
}