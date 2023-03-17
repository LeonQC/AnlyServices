docker rm -f pgsql-dev
docker run --name pgsql-dev -e POSTGRES_PASSWORD=123456 -e POSTGRES_DB=AnlyPostgres -d -p 5434:5432 postgres:14