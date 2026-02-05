module chess {
    requires java.base;
    requires javafx.fxml;
    requires javafx.controls;
    requires transitive javafx.graphics;
    opens ru.job4j.chess to javafx.fxml;
    exports ru.job4j.chess;
    exports ru.job4j.chess.firuges;
}