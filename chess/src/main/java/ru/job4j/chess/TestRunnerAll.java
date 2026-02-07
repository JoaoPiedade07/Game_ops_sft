package ru.job4j.chess;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.*;

public class TestRunnerAll {
    public static void main(String[] args) {
        System.out.println("\n📋  LISTA DE TESTES DO XADREZ");
        System.out.println("════════════════════════════════════════════");

        // Lista de testes sem saber resultado ainda
        List<String> testNames = Arrays.asList(
                "PawnWhiteMoveTest - Movimento válido do peão branco",
                "PawnInvalidMoveTest - Movimento inválido do peão",
                "RookCaptureTest - Captura da torre",
                "KnightMoveTest - Movimento do cavalo em L",
                "BishopInvalidMoveTest - Movimento do bispo"
        );

        List<String> testClasses = Arrays.asList(
                "ru.job4j.chess.PawnWhiteMoveTest",
                "ru.job4j.chess.PawnInvalidMoveTest",
                "ru.job4j.chess.RookCaptureTest",
                "ru.job4j.chess.KnightMoveTest",
                "ru.job4j.chess.BishopInvalidMoveTest"
        );

        // Mostra lista ANTES de executar (sem ✅/❌)
        for (int i = 0; i < testNames.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + testNames.get(i));
        }

        System.out.println("\n⚡  EXECUTANDO TESTES...");
        System.out.println("════════════════════════════════════════════\n");

        try {
            // Carrega as classes
            Class<?>[] testClassesArray = new Class[testClasses.size()];
            for (int i = 0; i < testClasses.size(); i++) {
                testClassesArray[i] = Class.forName(testClasses.get(i));
            }

            // Execute todos os testes
            Result result = JUnitCore.runClasses(testClassesArray);

            // Mapa para rastrear quais testes falharam
            Set<String> failedTests = new HashSet<>();
            for (Failure failure : result.getFailures()) {
                String className = failure.getDescription().getClassName();
                failedTests.add(className);
            }

            // Mostra resultado DEPOIS da execução
            System.out.println("\n════════════════════════════════════════════");
            System.out.println("RESULTADO DOS TESTES:");
            System.out.println("════════════════════════════════════════════");
            System.out.println("");

            for (int i = 0; i < testClasses.size(); i++) {
                String className = testClasses.get(i);
                String testName = testNames.get(i);
                String status = failedTests.contains(className) ? "❌ FALHOU" : "✅ PASSOU";

                System.out.println("  " + (i + 1) + ". " + status + " - " + testName);
            }

            System.out.println("");
            System.out.println("════════════════════════════════════════════");
            System.out.println("ESTATÍSTICAS:");
            System.out.println("════════════════════════════════════════════");
            System.out.println("Total de testes: " + result.getRunCount());
            System.out.println("Testes que passaram: " + (result.getRunCount() - result.getFailureCount()));
            System.out.println("Testes que falharam: " + result.getFailureCount());
            System.out.println("Tempo total: " + result.getRunTime() + "ms");

            // Se houver falhas, mostra detalhes
            if (!result.wasSuccessful()) {
                System.out.println("");
                System.out.println("════════════════════════════════════════════");
                System.out.println("DETALHES DAS FALHAS:");
                System.out.println("════════════════════════════════════════════");

                for (Failure failure : result.getFailures()) {
                    System.out.println("");
                    System.out.println("❌ " + failure.getDescription().getMethodName());
                    System.out.println("   Classe: " + failure.getDescription().getClassName());
                    if (failure.getMessage() != null) {
                        System.out.println("   Erro: " + failure.getMessage());
                    }
                    if (failure.getException() != null) {
                        System.out.println("   Exceção: " +
                                failure.getException().getClass().getSimpleName());
                        // Mostra só a primeira linha da stack trace para não poluir
                        if (failure.getException().getMessage() != null) {
                            System.out.println("   Detalhe: " +
                                    failure.getException().getMessage().split("\n")[0]);
                        }
                    }
                }
            }

            System.out.println("");
            System.out.println("════════════════════════════════════════════");
            if (result.wasSuccessful()) {
                System.out.println("🎉 TODOS OS TESTES PASSARAM COM SUCESSO!");
            } else {
                System.out.println("⚠️  ALGUNS TESTES FALHARAM. VERIFIQUE OS DETALHES.");
            }
            System.out.println("════════════════════════════════════════════");

            System.exit(result.wasSuccessful() ? 0 : 1);

        } catch (ClassNotFoundException e) {
            System.err.println("\n❌ ERRO: Classe de teste não encontrada!");
            System.err.println("Detalhes: " + e.getMessage());
            System.err.println("\nVerifique se:");
            System.err.println("1. Os testes foram compilados: mvn test-compile");
            System.err.println("2. O nome da classe está correto");
            System.exit(1);
        } catch (Exception e) {
            System.err.println("\n❌ ERRO INESPERADO: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}