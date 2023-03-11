#!/usr/bin/env bash
export PATH=/Library/PostgreSQL/15/bin:$PATH
PGPASSWORD=123456 psql -d AnlyPostgres -U postgres -p 5433 -f ~/Desktop/System\ Design\ Project/Anly/AnlyServices/src/main/resources/schema.sql




