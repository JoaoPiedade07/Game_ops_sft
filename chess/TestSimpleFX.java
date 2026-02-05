import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TestSimpleFX extends Application {
    @Override
    public void start(Stage stage) {
        System.out.println("=== START: JavaFX está funcionando! ===");
        Label label = new Label("✅ JavaFX funciona no macOS!\n\nEsta janela fecha em 3 segundos...");
        label.setStyle("-fx-font-size: 16px; -fx-padding: 20px;");
        Scene scene = new Scene(new StackPane(label), 500, 300);
        stage.setTitle("Teste JavaFX - macOS");
        stage.setScene(scene);
        stage.show();
        System.out.println("=== Janela exibida com sucesso ===");
        
        // Fecha automaticamente após 3 segundos
        new Thread(() -> {
            try {
                Thread.sleep(3000);
                Platform.runLater(() -> {
                    System.out.println("=== Fechando janela ===");
                    stage.close();
                    Platform.exit();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
    
    public static void main(String[] args) {
        System.out.println("=== MAIN: Iniciando aplicação JavaFX ===");
        launch(args);
        System.out.println("=== MAIN: Aplicação finalizada ===");
    }
}
