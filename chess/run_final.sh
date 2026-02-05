#!/bin/bash

# Encontre JavaFX 17
JAVAFX_JARS=$(find ~/.m2/repository/org/openjfx -name "*.jar" | grep -E "(javafx-(controls|fxml|graphics|base)-17.*mac-aarch64)" | tr '\n' ':')
JAVAFX_PATH=$(find ~/.m2/repository/org/openjfx -name "javafx-*.jar" | grep mac-aarch64 | head -1 | xargs dirname)

echo "Usando JavaFX de: $JAVAFX_PATH"

# Workaround específico para macOS Sequoia
export JAVA_TOOL_OPTIONS="-Dprism.order=sw -Dglass.platform=ios -Dprism.verbose=true"

java -cp "target/classes:$JAVAFX_JARS" \
    --module-path "$JAVAFX_PATH" \
    --add-modules javafx.controls,javafx.fxml,javafx.graphics,javafx.base \
    -Dprism.order=sw \
    -Dglass.platform=ios \
    -Dprism.verbose=true \
    -Dquantum.multithreaded=false \
    ru.job4j.chess.Chess
