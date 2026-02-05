public class TesteRapido {
    public static void main(String[] args) {
        System.out.println("=== TESTE RÁPIDO JAVA ===");
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("JavaFX disponível?");
        
        try {
            Class.forName("javafx.application.Application");
            System.out.println("✅ SIM - JavaFX Application encontrada");
        } catch (Exception e) {
            System.out.println("❌ NÃO - " + e.getMessage());
        }
    }
}
