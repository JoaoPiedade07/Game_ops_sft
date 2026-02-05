package ru.job4j.chess;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.figures.Cell;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleCellTest {
    @Test
    public void testCell() {
        Cell cell = Cell.A1;
        assertNotNull(cell);
        System.out.println("Success! Cell.A1 = " + cell);
    }
}
