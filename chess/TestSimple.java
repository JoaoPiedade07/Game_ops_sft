public class TestSimple {
    public static void main(String[] args) {
        System.out.println("=== Teste da Lógica do Xadrez ===");
        
        // Primeiro, teste se as classes existem
        try {
            Class<?> logicClass = Class.forName("ru.job4j.chess.Logic");
            System.out.println("✓ Classe Logic encontrada");
            
            Class<?> cellClass = Class.forName("ru.job4j.chess.figures.Cell");
            System.out.println("✓ Classe Cell encontrada");
            
            // Crie uma instância
            Object logic = logicClass.getDeclaredConstructor().newInstance();
            System.out.println("✓ Instância de Logic criada");
            
            // Teste o método getFigures
            Object[] figures = (Object[]) logicClass.getMethod("getFigures").invoke(logic);
            System.out.println("✓ Número de figuras no tabuleiro: " + figures.length);
            
        } catch (Exception e) {
            System.out.println("✗ Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
