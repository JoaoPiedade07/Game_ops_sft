package ru.job4j.chess;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.figures.Cell;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestCell {
    @Test
    public void testCellExists() {
        Cell cell = Cell.A1;
        assertNotNull(cell);
        System.out.println("Cell.A1 = " + cell);
    }
}
