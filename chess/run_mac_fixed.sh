#!/bin/bash

# Limpe e compile
mvn clean compile

# Execute com TODAS as flags conhecidas para evitar crash no macOS
java -cp "target/classes:$(find ~/.m2/repository -name '*.jar' 2>/dev/null | tr '\n' ':')" \
    --module-path "$(find ~/.m2/repository/org/openjfx -name 'javafx*.jar' 2>/dev/null | head -1 | xargs dirname)" \
    --add-modules javafx.controls,javafx.fxml,javafx.graphics,javafx.base \
    -Dprism.order=sw \
    -Dglass.platform=ios \
    -Dprism.verbose=true \
    -Dprism.forceGPU=false \
    -Dprism.dirtyopts=false \
    -Djavafx.animation.fullspeed=true \
    -Djavafx.animation.pulse=true \
    -Dquantum.multithreaded=false \
    -Dglass.win.uiScale=100% \
    -Dglass.gtk.uiScale=100% \
    -Dprism.lcdtext=false \
    -Dprism.subpixeltext=false \
    -Dprism.text=t2k \
    -Dprism.maxvram=512M \
    -Dprism.vsync=false \
    ru.job4j.chess.Chess
