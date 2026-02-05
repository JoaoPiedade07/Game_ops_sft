public class TestClasspath {
    public static void main(String[] args) throws Exception {
        System.out.println("Testando carga de classes...");
        Class<?> chessClass = Class.forName("ru.job4j.chess.Chess");
        System.out.println("✓ Chess carregada: " + chessClass);
        
        Class<?> logicClass = Class.forName("ru.job4j.chess.Logic");
        System.out.println("✓ Logic carregada: " + logicClass);
        
        System.out.println("\n✓ Todas as classes principais carregadas com sucesso!");
    }
}
