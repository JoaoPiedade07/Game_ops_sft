package ru.job4j.chess;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import ru.job4j.chess.figures.Cell;

public class LogicTest {

    private Logic logic;

    @Before
    public void setUp() {
        logic = new Logic();
        logic.clean();
    }

    @Test
    public void whenMoveFromEmptyCellThenFigureNotFoundException() {
        try {
            logic.move(Cell.C1, Cell.H6);
            fail("Deveria lançar FigureNotFoundException ao mover de célula vazia");
        } catch (FigureNotFoundException e) {
            assertEquals("Figure not found on the board.", e.getMessage());
        } catch (Exception e) {
            fail("Deveria lançar FigureNotFoundException, mas lançou: " + e.getClass().getSimpleName());
        }
    }
}
