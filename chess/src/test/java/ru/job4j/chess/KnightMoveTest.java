package ru.job4j.chess;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.white.KnightWhite;
import ru.job4j.chess.figures.Figure;

public class KnightMoveTest {

    private Logic logic;

    @Before
    public void setUp() {
        logic = new Logic();
        logic.clean();
    }

    @Test
    public void whenKnightMovesInLPatternValidMove() {
        Figure knight = new KnightWhite(Cell.B1);
        logic.add(knight);

        try {
            logic.move(Cell.B1, Cell.C3);
            Figure movedKnight = logic.getFigureAt(Cell.C3);
            
            assertNotNull("Cavalo deveria estar em C3", movedKnight);
            assertEquals("Após mover, cavalo deveria estar em C3",
                    Cell.C3, movedKnight.position());
            
            // Verificar que a posição original está vazia
            assertNull("Posição original deveria estar vazia", 
                    logic.getFigureAt(Cell.B1));

        } catch (Exception e) {
            fail("ERRO ao mover cavalo: " + e.getClass().getSimpleName() +
                    " - " + e.getMessage());
        }
    }
}
