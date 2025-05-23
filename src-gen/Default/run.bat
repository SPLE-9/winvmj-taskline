echo SELECT 'CREATE DATABASE taskline_product_default' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'taskline_product_default') \gexec | psql "postgresql://postgres:postgres@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:postgres@localhost/taskline_product_default"

java -cp taskline.product.default --module-path taskline.product.default -m taskline.product.default