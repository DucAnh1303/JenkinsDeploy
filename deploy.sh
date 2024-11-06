#!/bin/bash

git pull origin master

./gradlew clean build -x test

docker stop application || true
docker rm application || true

docker build -t run_project_jenkins .

docker run -d -p 9091:9091 --name application run_project_jenkins