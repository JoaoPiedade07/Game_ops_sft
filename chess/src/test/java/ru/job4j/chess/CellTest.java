package ru.job4j.chess;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.figures.Cell;
import static org.junit.jupiter.api.Assertions.*;

public class CellTest {
    @Test
    public void testCell() {
        Cell c1 = Cell.C1;
        Cell h6 = Cell.H6;
        assertNotNull(c1);
        assertNotNull(h6);
        assertNotEquals(c1, h6);
        System.out.println("C1 = " + c1);
        System.out.println("H6 = " + h6);
    }
}
