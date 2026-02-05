#!/bin/bash

# Encontre os jars do JavaFX 21
JAVAFX_PATH=$(find ~/.m2/repository/org/openjfx -name "javafx-*.jar" | grep -v sources | grep -v javadoc | head -1 | xargs dirname)
JAVAFX_CP=$(find ~/.m2/repository/org/openjfx -name "*.jar" | grep -E "(javafx-(controls|fxml|graphics|base)-21)" | grep -v sources | grep -v javadoc | tr '\n' ':')

echo "JavaFX path: $JAVAFX_PATH"
echo "JavaFX classpath preparado."

# Execute
java -cp "target/classes:$JAVAFX_CP" \
    --module-path "$JAVAFX_PATH" \
    --add-modules javafx.controls,javafx.fxml,javafx.graphics,javafx.base \
    -Dprism.order=sw \
    -Dglass.platform=ios \
    ru.job4j.chess.Chess
