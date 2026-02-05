#!/bin/bash

echo "=== DEBUG: Verificando ambiente ==="
echo "1. Java version:"
java -version 2>&1
echo ""
echo "2. JAVA_HOME: $JAVA_HOME"
echo ""
echo "3. Chess.class existe?"
ls -la target/classes/ru/job4j/chess/Chess.class 2>/dev/null && echo "✓ SIM" || echo "✗ NÃO"
echo ""
echo "4. JavaFX jars encontrados:"
find ~/.m2/repository/org/openjfx -name "*.jar" | grep -E "javafx-(controls|fxml|graphics|base)" | grep "17.0.0.1" | head -8
echo ""
echo "5. Testando classpath simples:"
cat > TestClasspath.java << 'TEST'
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
TEST
javac -cp "target/classes" TestClasspath.java
java -cp "target/classes:." TestClasspath
