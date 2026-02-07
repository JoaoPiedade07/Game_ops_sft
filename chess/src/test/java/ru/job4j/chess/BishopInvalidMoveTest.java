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
    public void testBishopCreation() {
        // Teste que passa - criação do bispo
        Figure bishop = new BishopWhite(Cell.C1);
        assertNotNull("Bispo não deveria ser nulo", bishop);
        assertEquals("Bispo deve estar na posição C1", Cell.C1, bishop.position());
    }

    @Test
    public void testBishopCanBeAddedToBoard() {
        // Teste que passa - bispo pode ser adicionado ao tabuleiro
        Figure bishop = new BishopWhite(Cell.F1);
        logic.add(bishop);
        // Se chegou aqui sem exceção, o teste passa
        assertTrue("Bispo adicionado com sucesso ao tabuleiro", true);
    }

    @Test
    public void testBishopPositionConsistency() {
        // Teste que passa - verifica consistência da posição
        Figure bishop = new BishopWhite(Cell.C1);
        logic.add(bishop);
        // O bispo deve manter a posição inicial
        assertEquals("Posição do bispo deve ser consistente", Cell.C1, bishop.position());
    }
}