package ru.job4j.chess.figures.white;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

public class RookWhite implements Figure {
    private final Cell position;

    public RookWhite(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isLinear(position, dest)) {
            throw new IllegalStateException(
                    String.format("Não é possível mover torre de %s para %s", position, dest)
            );
        }
        
        int deltaX = Integer.compare(dest.getX(), position.getX());
        int deltaY = Integer.compare(dest.getY(), position.getY());
        int size = Math.max(
                Math.abs(dest.getX() - position.getX()),
                Math.abs(dest.getY() - position.getY())
        );
        
        Cell[] steps = new Cell[size];
        for (int index = 0; index < size; index++) {
            int x = position.getX() + deltaX * (index + 1);
            int y = position.getY() + deltaY * (index + 1);
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    private boolean isLinear(Cell source, Cell dest) {
        return source.getX() == dest.getX() || source.getY() == dest.getY();
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookWhite(dest);
    }
}