echo SELECT 'CREATE DATABASE taskline_product_basic' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'taskline_product_basic') \gexec | psql "postgresql://postgres:postgres@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:postgres@localhost/taskline_product_basic"

java -cp taskline.product.basic --module-path taskline.product.basic -m taskline.product.basic