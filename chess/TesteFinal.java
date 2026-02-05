import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TesteFinal extends Application {
    @Override
    public void start(Stage stage) {
        System.out.println("✅ JavaFX start() CHAMADO!");
        
        Label label = new Label("🎉 JAVAFX FUNCIONA NO macOS!\n\n"
                              + "Se você vê esta janela,\n"
                              + "o problema está apenas no Chess.\n\n"
                              + "Fecha automaticamente em 10 segundos...");
        
        Scene scene = new Scene(label, 500, 400);
        stage.setScene(scene);
        stage.setTitle("✅ TESTE JAVAFX - SUCESSO!");
        stage.setAlwaysOnTop(true);
        stage.show();
        
        System.out.println("✅ Janela MOSTRADA! Deve estar visível agora.");
        System.out.println("📱 Verifique seu ecrã!");
        
        // Posiciona bem no centro
        stage.centerOnScreen();
        stage.toFront();
        
        // Fecha após 10 segundos
        new Thread(() -> {
            try {
                Thread.sleep(10000);
                Platform.runLater(() -> {
                    System.out.println("⏹️  Fechando teste...");
                    Platform.exit();
                });
            } catch (Exception e) {}
        }).start();
    }
    
    public static void main(String[] args) {
        System.out.println("🚀 Iniciando teste JavaFX...");
        launch(args);
        System.out.println("🏁 Teste finalizado.");
    }
}
