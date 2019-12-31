#!/usr/bin/env sh

./gradlew clean build

docker build -t rogiller/just-run-containers-demo .

docker tag rogiller/just-run-containers-demo rogiller/just-run-containers-demo:latest

docker push rogiller/just-run-containers-demo:latest