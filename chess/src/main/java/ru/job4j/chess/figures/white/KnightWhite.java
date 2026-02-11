package ru.job4j.chess.figures.white;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

public class KnightWhite implements Figure {
    private final Cell position;

    public KnightWhite(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isKnightMove(position, dest)) {
            throw new IllegalStateException(
                    String.format("Não é possível mover cavalo de %s para %s", position, dest)
            );
        }
        return new Cell[] { dest };
    }

    private boolean isKnightMove(Cell source, Cell dest) {
        int deltaX = Math.abs(dest.getX() - source.getX());
        int deltaY = Math.abs(dest.getY() - source.getY());
        return (deltaX == 2 && deltaY == 1) || (deltaX == 1 && deltaY == 2);
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightWhite(dest);
    }
}