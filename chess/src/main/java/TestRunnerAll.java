package ru.job4j.chess;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunnerAll {
    public static void main(String[] args) {
        System.out.println("\n📋  Lista de testes:");
        System.out.println("  1. ✅ PawnWhiteMoveTest - Movimento válido do peão branco");
        System.out.println("  2. ✅ PawnInvalidMoveTest - Movimento inválido do peão");
        System.out.println("  3. ✅ RookCaptureTest - Captura da torre");
        System.out.println("  4. ✅ KnightMoveTest - Movimento do cavalo em L");
        System.out.println("\n⚡  Executando...\n");

        try {
            // Carrega as classes usando reflection
            Class<?>[] testClasses = {
                    Class.forName("ru.job4j.chess.PawnWhiteMoveTest"),
                    Class.forName("ru.job4j.chess.PawnInvalidMoveTest"),
                    Class.forName("ru.job4j.chess.RookCaptureTest"),
                    Class.forName("ru.job4j.chess.KnightMoveTest")
            };

            // Execute todos os testes
            Result result = JUnitCore.runClasses(testClasses);

            // Mostra resultado final
            System.out.println("\n════════════════════════════════════════════");
            System.out.println("RESULTADO FINAL:");
            System.out.println("════════════════════════════════════════════");

            if (result.wasSuccessful()) {
                System.out.println("🎯 TODOS OS 4 TESTES PASSARAM!");
                System.out.println("\nDetalhes:");
                System.out.println("✅ Teste 1: Movimento válido do peão branco");
                System.out.println("✅ Teste 2: Movimento inválido do peão");
                System.out.println("✅ Teste 3: Captura da torre");
                System.out.println("✅ Teste 4: Movimento do cavalo em L");
                System.out.println("\n⏱️  Tempo total: " + result.getRunTime() + "ms");
            } else {
                System.out.println("❌ " + result.getFailureCount() + " TESTE(S) FALHARAM:");
                for (Failure failure : result.getFailures()) {
                    System.out.println("\n❌ " + failure.getDescription().getMethodName());
                    System.out.println("   " + failure.getMessage());
                }
            }

            System.exit(result.wasSuccessful() ? 0 : 1);

        } catch (ClassNotFoundException e) {
            System.err.println("❌ ERRO: Classe de teste não encontrada!");
            System.err.println("Detalhes: " + e.getMessage());
            System.exit(1);
        }
    }
}