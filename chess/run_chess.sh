#!/bin/bash

echo "=== Configurando ambiente para JavaFX no macOS ==="

# Encontre JavaFX 17 (a versão que temos no pom.xml)
echo "Buscando JavaFX 17..."
JAVAFX_BASE=$(find ~/.m2/repository/org/openjfx -name "javafx-base-17*.jar" | grep -v sources | grep -v javadoc | head -1)
if [ -z "$JAVAFX_BASE" ]; then
    echo "ERRO: JavaFX 17 não encontrado!"
    exit 1
fi

JAVAFX_PATH=$(dirname "$JAVAFX_BASE")
echo "JavaFX encontrado em: $JAVAFX_PATH"

# Monte o classpath com TODOS os jars do JavaFX
CLASSPATH="target/classes"
for jar in $(find "$JAVAFX_PATH" -name "*.jar" | grep -E "javafx-(controls|fxml|graphics|base).*\.jar$" | grep -v sources | grep -v javadoc); do
    CLASSPATH="$CLASSPATH:$jar"
done

echo "Classpath preparado (tamanho: ${#CLASSPATH} caracteres)"

# Flags específicas para macOS Sequoia/Sonoma
echo "Executando com workaround para macOS..."
java -cp "$CLASSPATH" \
    --module-path "$JAVAFX_PATH" \
    --add-modules javafx.controls,javafx.fxml,javafx.graphics,javafx.base \
    -Dprism.order=sw \
    -Dglass.platform=ios \
    -Dprism.verbose=true \
    -Dquantum.multithreaded=false \
    -Djavafx.animation.fullspeed=true \
    -Dprism.forceGPU=false \
    ru.job4j.chess.Chess
