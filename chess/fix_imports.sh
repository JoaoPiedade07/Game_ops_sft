#!/bin/bash

# Corrige todos os imports de firuges para figures
find . -name "*.java" -type f -exec grep -l "firuges" {} \; | while read file; do
    echo "Corrigindo $file"
    sed -i '' 's/firuges/figures/g' "$file"
done

echo "Imports corrigidos!"
