echo SELECT 'CREATE DATABASE taskline_product_tasklineanalytic' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'taskline_product_tasklineanalytic') \gexec | psql "postgresql://postgres:postgres@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:postgres@localhost/taskline_product_tasklineanalytic"

java -cp taskline.product.tasklineanalytic --module-path taskline.product.tasklineanalytic -m taskline.product.tasklineanalytic