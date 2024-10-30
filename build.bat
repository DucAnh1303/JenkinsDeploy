@echo off
call git fetch && git reset --hard origin/master && gradlew clean && gradlew build
echo Test 1
call docker stop jenkins
echo Test 2
call docker rm jenkins
call docker build -t jenkins .
call docker run -t -d --network host --name jenkins --restart=always jenkins
call docker image prune -a -f