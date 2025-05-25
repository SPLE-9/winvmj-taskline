#!/bin/bash

cleanup() {
    echo "Exiting script..."
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

read -p "Enter the path to the frontend directory: " frontend_dir

echo "SELECT 'CREATE DATABASE taskline_product_tasklineanalytic' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'taskline_product_tasklineanalytic') \gexec" | psql "postgresql://postgres:postgres@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:postgres@localhost/taskline_product_tasklineanalytic"
done

java -cp taskline.product.tasklineanalytic --module-path taskline.product.tasklineanalytic -m taskline.product.tasklineanalytic &

cd $frontend_dir && {
    npm install && {
        npm run json:server &
        npm run start &
    }
}

wait