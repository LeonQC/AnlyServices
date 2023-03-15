docker rm -f pgsql-dev
docker run --name pgsql-dev -e POSTGRES_PASSWORD=123456 -e POSTGRES_DB=AnlyPostgres -d -p 5434:5432 postgres
sleep 3
docker cp ./schema.sql pgsql-dev:/docker-entrypoint-initdb.d/schema.sql
docker exec -it pgsql-dev psql -U postgres -d AnlyPostgres -f docker-entrypoint-initdb.d/schema.sql