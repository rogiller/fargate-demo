#!/usr/bin/env sh

./gradlew clean build

docker build -t rogiller/fargate-demo .

docker run -p 8080:8080 -t rogiller/fargate-demo