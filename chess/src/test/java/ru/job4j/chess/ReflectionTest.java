package ru.job4j.chess;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReflectionTest {
    @Test
    public void testCellViaReflection() throws Exception {
        // Tente carregar a classe via reflexão
        Class<?> cellClass = Class.forName("ru.job4j.chess.figures.Cell");
        assertNotNull(cellClass);
        
        // Verifique se é um enum
        assertTrue(cellClass.isEnum());
        
        // Tente acessar um valor
        Enum<?> a1 = Enum.valueOf((Class<Enum>) cellClass, "A1");
        assertNotNull(a1);
        
        System.out.println("Successfully loaded Cell class: " + cellClass);
        System.out.println("Cell.A1 = " + a1);
    }
}
