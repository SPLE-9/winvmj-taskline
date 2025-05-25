#!/bin/bash
source ~/.zshrc  

cleanup() {
    pkill -P $$
    rm java.log
    exit 1
}

trap cleanup SIGINT

java -cp taskline.product.tasklineanalytic --module-path taskline.product.tasklineanalytic -m taskline.product.tasklineanalytic 2>&1 | tee java.log &
JAVA_PID=$!
TEE_PID=$(pgrep -n tee)
tail -f java.log --pid=$TEE_PID | while read -r LINE; do
    if [[ "$LINE" == *"== CREATING OBJECTS AND BINDING ENDPOINTS =="* ]]; then
        break
    fi
done

echo "SELECT 'CREATE DATABASE taskline_product_tasklineanalytic' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'taskline_product_tasklineanalytic') \gexec" | psql "postgresql://postgres:postgres@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:postgres@localhost/taskline_product_tasklineanalytic"
done

wait