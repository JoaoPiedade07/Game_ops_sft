import ru.job4j.chess.Logic;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.black.*;
import ru.job4j.chess.figures.white.*;

public class TestChessLogic {
    public static void main(String[] args) {
        System.out.println("Testando lógica do xadrez...");
        Logic logic = new Logic();
        
        // Adicione algumas peças
        logic.add(new PawnBlack(Cell.A7));
        logic.add(new PawnWhite(Cell.A2));
        
        System.out.println("Lógica inicializada com sucesso!");
        System.out.println("Peças no tabuleiro: " + logic.getFigures().length);
        
        // Teste movimentos simples
        try {
            boolean canMove = logic.move(Cell.A7, Cell.A6);
            System.out.println("Movimento possível: " + canMove);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
