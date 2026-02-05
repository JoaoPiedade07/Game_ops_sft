public class MinimalTest {
    public static void main(String[] args) throws Exception {
        System.out.println("Carregando JavaFX...");
        
        // Tenta carregar uma classe JavaFX
        try {
            Class<?> appClass = Class.forName("javafx.application.Application");
            System.out.println("✅ JavaFX Application class carregada: " + appClass);
            
            Class<?> stageClass = Class.forName("javafx.stage.Stage");
            System.out.println("✅ JavaFX Stage class carregada: " + stageClass);
            
            System.out.println("\n✅ JavaFX está disponível no classpath!");
            System.out.println("O problema pode estar no código Chess específico.");
        } catch (ClassNotFoundException e) {
            System.err.println("❌ JavaFX não encontrada: " + e.getMessage());
            System.err.println("Classpath atual não inclui JavaFX corretamente.");
        }
    }
}
