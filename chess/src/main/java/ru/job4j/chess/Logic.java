package ru.job4j.chess;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import java.util.Arrays;

public final class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        figures[index++] = figure;
    }

    public void move(Cell source, Cell dest)
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        
        // 1. Encontrar a figura na posição source
        int sourceIndex = findBy(source);
        Figure figure = figures[sourceIndex];
        
        // 2. Calcular o caminho até ao destino
        Cell[] steps;
        try {
            steps = figure.way(dest);
        } catch (IllegalStateException e) {
            throw new ImpossibleMoveException(e.getMessage());
        }
        
        // 3. Verificar se o caminho está livre (exceto o destino)
        for (int i = 0; i < steps.length - 1; i++) {
            if (steps[i] != null && findByCell(steps[i]) != -1) {
                throw new OccupiedCellException("Célula ocupada: " + steps[i]);
            }
        }
        
        // 4. Verificar o destino - pode ter peça adversária (captura)
        int destIndex = findByCell(dest);
        if (destIndex != -1) {
            Figure destFigure = figures[destIndex];
            
            // Verificar se é da mesma cor
            boolean sourceIsWhite = figure.getClass().getSimpleName().contains("White");
            boolean destIsWhite = destFigure.getClass().getSimpleName().contains("White");
            
            if (sourceIsWhite == destIsWhite) {
                throw new OccupiedCellException("Destino ocupado por peça da mesma cor");
            }
            
            // REMOVER a peça capturada
            figures[destIndex] = null;
        }
        
        // 5. MOVER A PEÇA - substituir no mesmo índice
        Figure movedFigure = figure.copy(dest);
        figures[sourceIndex] = movedFigure;
    }

    public Figure getFigureAt(Cell cell) {
        int index = findByCell(cell);
        if (index != -1) {
            return figures[index];
        }
        return null;
    }

    private int findBy(Cell cell) throws FigureNotFoundException {
        for (int i = 0; i < figures.length; i++) {
            Figure figure = figures[i];
            if (figure != null && figure.position().equals(cell)) {
                return i;
            }
        }
        throw new FigureNotFoundException("Figure not found on the board.");
    }
    
    private int findByCell(Cell cell) {
        for (int i = 0; i < figures.length; i++) {
            Figure figure = figures[i];
            if (figure != null && figure.position().equals(cell)) {
                return i;
            }
        }
        return -1;
    }

    public void clean() {
        Arrays.fill(figures, null);
        index = 0;
    }
}