package ru.job4j.chess.figures.white;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

public class PawnWhite implements Figure {
    private final Cell position;

    public PawnWhite(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        // Peão branco move para Y MENOR (para frente no tabuleiro)
        if (dest.getY() >= position.getY()) {
            throw new IllegalStateException(
                    "Peão branco não pode mover para trás"
            );
        }
        
        // Verificar se moveu na mesma coluna
        if (dest.getX() != position.getX()) {
            throw new IllegalStateException(
                    "Peão branco não pode mover para os lados"
            );
        }
        
        int deltaY = position.getY() - dest.getY(); // Positivo = move para frente
        
        // Move 1 casa (sempre permitido)
        if (deltaY == 1) {
            return new Cell[] { dest };
        }
        
        // Move 2 casas - só permitido se estiver na posição inicial (linha 6)
        if (deltaY == 2) {
            // Verificar se está na linha 6 (posição inicial do peão branco)
            if (position.getY() == 6) {
                return new Cell[] { 
                    Cell.findBy(position.getX(), position.getY() - 1),
                    dest 
                };
            }
        }
        
        throw new IllegalStateException(
                "Movimento inválido para peão branco"
        );
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnWhite(dest);
    }
}
