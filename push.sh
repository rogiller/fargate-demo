#!/usr/bin/env sh

./gradlew clean build

docker build -t rogiller/fargate-demo .

docker tag rogiller/fargate-demo rogiller/fargate-demo:latest

docker push rogiller/fargate-demo:latest