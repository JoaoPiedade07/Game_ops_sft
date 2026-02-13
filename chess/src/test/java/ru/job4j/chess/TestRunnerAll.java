package ru.job4j.chess;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.*;

public class TestRunnerAll {
    public static void main(String[] args) {
        System.out.println("\n LISTA DE TESTES DO XADREZ");
        System.out.println("════════════════════════════════════════════");

        List<String> testNames = Arrays.asList(
                "PawnWhiteMoveTest - Movimento válido e inválido do peão branco",
                "RookCaptureTest - Captura da torre",
                "KnightMoveTest - Movimento do cavalo em L",
                "BishopValidMoveTest - Movimento diagonal válido do bispo",
                "FigureNotFoundExceptionTest - Exceção quando não há peça na célula",
                "KingMoveTest - Movimento do rei",
                "QueenMoveTest - Movimento da rainha"
        );

        List<String> testClasses = Arrays.asList(
                "ru.job4j.chess.PawnWhiteMoveTest",
                "ru.job4j.chess.RookCaptureTest",
                "ru.job4j.chess.KnightMoveTest",
                "ru.job4j.chess.BishopValidMoveTest",
                "ru.job4j.chess.FigureNotFoundExceptionTest",
                "ru.job4j.chess.KingMoveTest",
                "ru.job4j.chess.QueenMoveTest"
        );

        for (int i = 0; i < testNames.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + testNames.get(i));
        }

        System.out.println("\n⚡  EXECUTANDO TESTES...");
        System.out.println("════════════════════════════════════════════\n");

        try {
            Class<?>[] testClassesArray = new Class[testClasses.size()];
            // Cria um "container" vazio para guardar as classes de teste
            for (int i = 0; i < testClasses.size(); i++) {
                testClassesArray[i] = Class.forName(testClasses.get(i));
            }
            // Pega cada nome de classe (ex: "PawnWhiteMoveTest") e carrega ela na memória

            Result result = JUnitCore.runClasses(testClassesArray);
            // Manda o JUnit executar TODOS os testes dessas classes

            
            Set<String> failedTests = new HashSet<>();
            for (Failure failure : result.getFailures()) {
                String className = failure.getDescription().getClassName();
                failedTests.add(className);
            }
            // Guarda quais classes tiveram falhas para mostrar depois

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
                System.out.println("TODOS OS TESTES PASSARAM COM SUCESSO!");
            } else {
                System.out.println("❌ ALGUNS TESTES FALHARAM. VERIFIQUE OS DETALHES.");
            }
            System.out.println("════════════════════════════════════════════");

            System.exit(result.wasSuccessful() ? 0 : 1);

        } catch (ClassNotFoundException e) { //Erro específico (Classe)
            System.err.println("\n❌ ERRO: Classe de teste não encontrada!");
            System.err.println("Detalhes: " + e.getMessage());
            System.exit(1);
        } catch (Exception e) { //Erro genérico
            System.err.println("\n❌ ERRO INESPERADO: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}