#!/bin/bash

cleanup() {
    echo "Exiting script..."
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

read -p "Enter the path to the frontend directory: " frontend_dir

echo "SELECT 'CREATE DATABASE taskline_product_appointment' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'taskline_product_appointment') \gexec" | psql "postgresql://postgres:postgres@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:postgres@localhost/taskline_product_appointment"
done

java -cp taskline.product.appointment --module-path taskline.product.appointment -m taskline.product.appointment &

cd $frontend_dir && {
    npm install && {
        npm run json:server &
        npm run start &
    }
}

wait