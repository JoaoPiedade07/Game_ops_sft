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
            assertEquals("Após mover, cavalo deveria estar em C3",
                    Cell.C3, knight.position());

        } catch (Exception e) {
            fail("ERRO ao mover cavalo: " + e.getClass().getSimpleName() +
                    " - " + e.getMessage());
        }
    }
}