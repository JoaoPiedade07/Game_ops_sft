import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TestWindow extends Application {
    @Override
    public void start(Stage stage) {
        System.out.println("TEST: Janela JavaFX deve abrir AGORA!");
        Label label = new Label("TESTE: Se vê isto, JavaFX funciona!");
        stage.setScene(new Scene(label, 400, 300));
        stage.setTitle("Teste de Janela");
        stage.setAlwaysOnTop(true);  // Força ficar no topo
        stage.show();
        stage.toFront();
        
        System.out.println("TEST: Janela mostrada. Fechando em 5 segundos...");
        
        // Fecha automaticamente após 5 segundos
        new Thread(() -> {
            try {
                Thread.sleep(5000);
                Platform.runLater(() -> {
                    Platform.exit();
                });
            } catch (Exception e) {}
        }).start();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
