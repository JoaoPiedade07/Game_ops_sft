package ru.job4j.chess;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunnerAll {
    public static void main(String[] args) {
        System.out.println("=== EXECUTANDO OS 4 TESTES DO CHESS ===\n");
        
        // Execute todos os testes
        Result result = JUnitCore.runClasses(
            PawnWhiteMoveTest.class,
            PawnInvalidMoveTest.class, 
            RookCaptureTest.class,
            KnightMoveTest.class
        );
        
        // Resultados
        System.out.println("========================================");
        System.out.println("RESULTADOS:");
        System.out.println("========================================");
        System.out.println("Total de testes: " + result.getRunCount());
        System.out.println("Testes que falharam: " + result.getFailureCount());
        System.out.println("Testes ignorados: " + result.getIgnoreCount());
        System.out.println("Tempo total: " + result.getRunTime() + "ms");
        System.out.println("========================================\n");
        
        if (result.wasSuccessful()) {
            System.out.println("✅ TODOS OS 4 TESTES PASSARAM COM SUCESSO!");
            System.out.println("\nDetalhes:");
            System.out.println("1. ✅ Movimento válido do peão branco");
            System.out.println("2. ✅ Movimento inválido do peão");
            System.out.println("3. ✅ Captura da torre");
            System.out.println("4. ✅ Movimento do cavalo em L");
        } else {
            System.out.println("❌ ALGUNS TESTES FALHARAM:");
            for (Failure failure : result.getFailures()) {
                System.out.println("\n❌ " + failure.getDescription().getMethodName());
                System.out.println("   " + failure.getMessage());
                if (failure.getException() != null) {
                    System.out.println("   Exceção: " + failure.getException().getClass().getSimpleName());
                    System.out.println("   " + failure.getException().getMessage());
                    failure.getException().printStackTrace();
                }
            }
        }
        
        System.exit(result.wasSuccessful() ? 0 : 1);
    }
}
