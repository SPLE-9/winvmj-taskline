echo SELECT 'CREATE DATABASE taskline_product_variantone' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'taskline_product_variantone') \gexec | psql "postgresql://postgres:postgres@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:postgres@localhost/taskline_product_variantone"

java -cp taskline.product.variantone --module-path taskline.product.variantone -m taskline.product.variantone