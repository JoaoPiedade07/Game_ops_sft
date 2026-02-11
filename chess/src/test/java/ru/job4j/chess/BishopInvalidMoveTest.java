package ru.job4j.chess;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.white.BishopWhite;
import ru.job4j.chess.figures.Figure;

public class BishopInvalidMoveTest {

    private Logic logic;

    @Before
    public void setUp() {
        logic = new Logic();
        logic.clean();
    }

    @Test
    public void whenBishopMovesDiagonallyThenPositionUpdates() {
        // Arrange
        Figure bishop = new BishopWhite(Cell.C1);
        logic.add(bishop);
        
        // Act
        try {
            logic.move(Cell.C1, Cell.E3);
            
            // Assert - AGORA USA getFigureAt()!
            Figure movedBishop = logic.getFigureAt(Cell.E3);
            assertNotNull("Bispo deveria estar em E3", movedBishop);
            assertEquals("Bispo moveu na diagonal", Cell.E3, movedBishop.position());
            
            // Verificar que a posição original está vazia
            assertNull("Célula original deveria estar vazia", logic.getFigureAt(Cell.C1));
            
        } catch (Exception e) {
            fail("Movimento diagonal do bispo falhou: " + e.getMessage());
        }
    }
}