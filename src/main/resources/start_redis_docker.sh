docker rm -f redis-dev
docker run --name redis-dev -p 6379:6379 -d redis