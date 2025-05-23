#!/bin/bash

cleanup() {
    echo "Exiting script..."
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

read -p "Enter the path to the frontend directory: " frontend_dir

echo "SELECT 'CREATE DATABASE taskline_product_default' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'taskline_product_default') \gexec" | psql "postgresql://postgres:postgres@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:postgres@localhost/taskline_product_default"
done

java -cp taskline.product.default --module-path taskline.product.default -m taskline.product.default &

cd $frontend_dir && {
    npm install && {
        npm run json:server &
        npm run start &
    }
}

wait