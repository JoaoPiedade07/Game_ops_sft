import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TestJavaFX {
    public static void main(String[] args) {
        System.out.println("Testando JavaFX...");
        
        // Inicia JavaFX em uma thread separada
        new Thread(() -> {
            Application.launch(TestApp.class, args);
        }).start();
    }
    
    public static class TestApp extends Application {
        @Override
        public void start(Stage stage) {
            System.out.println("JavaFX Start() chamado!");
            Label label = new Label("JavaFX FUNCIONA!");
            stage.setScene(new Scene(label, 300, 200));
            stage.setTitle("Sucesso!");
            stage.show();
            System.out.println("Janela deve estar visível agora!");
        }
    }
}
