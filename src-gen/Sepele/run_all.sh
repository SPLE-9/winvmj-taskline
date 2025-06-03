#!/bin/bash

cleanup() {
    echo "Exiting script..."
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

read -p "Enter the path to the frontend directory: " frontend_dir

echo "SELECT 'CREATE DATABASE taskline_product_sepele' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'taskline_product_sepele') \gexec" | psql "postgresql://postgres:postgres@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:postgres@localhost/taskline_product_sepele"
done

java -cp taskline.product.sepele --module-path taskline.product.sepele -m taskline.product.sepele &

cd $frontend_dir && {
    npm install && {
        npm run json:server &
        npm run start &
    }
}

wait