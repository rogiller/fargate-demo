#!/usr/bin/env sh

./gradlew clean build

docker build -t rogiller/just-run-containers-demo .

docker run -p 8080:8080 -t rogiller/just-run-containers-demo