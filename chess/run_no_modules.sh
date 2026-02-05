#!/bin/bash

echo "=== Executando sem sistema de módulos ==="

# Colete TODOS os jars necessários
ALL_JARS="target/classes"

# Adicione JavaFX
for jar in $(find ~/.m2/repository/org/openjfx -name "*.jar" | grep -E "javafx-(controls|fxml|graphics|base).*mac-aarch64\.jar$"); do
    ALL_JARS="$ALL_JARS:$jar"
    echo "Adicionado: $(basename $jar)"
done

echo "Executando..."
java -cp "$ALL_JARS" \
    -Dprism.order=sw \
    -Dglass.platform=ios \
    -Dprism.verbose=true \
    ru.job4j.chess.Chess
