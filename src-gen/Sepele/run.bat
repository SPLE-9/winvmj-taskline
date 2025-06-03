echo SELECT 'CREATE DATABASE taskline_product_sepele' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'taskline_product_sepele') \gexec | psql "postgresql://postgres:postgres@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:postgres@localhost/taskline_product_sepele"

java -cp taskline.product.sepele --module-path taskline.product.sepele -m taskline.product.sepele