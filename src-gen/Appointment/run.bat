echo SELECT 'CREATE DATABASE taskline_product_appointment' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'taskline_product_appointment') \gexec | psql "postgresql://postgres:postgres@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:postgres@localhost/taskline_product_appointment"

java -cp taskline.product.appointment --module-path taskline.product.appointment -m taskline.product.appointment