#!/bin/bash

# Colete todos os jars do JavaFX
ALL_JARS="target/classes"
for jar in $(find ~/.m2/repository/org/openjfx -name "*.jar" | grep -E "(javafx-(controls|fxml|graphics|base))" | grep -v sources | grep -v javadoc); do
    ALL_JARS="$ALL_JARS:$jar"
done

echo "Executando em modo classpath (sem módulos)..."
java -cp "$ALL_JARS" \
    -Dprism.order=sw \
    -Dglass.platform=ios \
    -Dprism.verbose=true \
    ru.job4j.chess.Chess
