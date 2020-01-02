# just-run-containers-demo

### Overview
This is a demo project to show the benefits of using a Docker container image as the deployment artifact.

### Benefits of the "Container As Deployment Artifact"
1) Everything your app needs is bundled... JDK version, 3rd Party Library versions, code changes, and other environment pieces all ship as one.
2) It's cloud compute vendor independent. You can run your app anywhere where running containers is supported.
3) Continuous deployment becomes as easy as publishing a new image via your CI tool.
4) Auto scaling and keeping your application running becomes the concern of the provider.
5) You can focus on writing your application and sleep better at night!

### How This Could Work in The Real World

##### Initial One Time Setup
1) Push the initial container image to DockerHub
2) Setup an App Service on Azure that runs instances of this container and auto load balances, etc

##### Development Flow
1) Commit & Push to GitHub
2) Travis CI (or other CI) builds & uploads Docker image
3) A web hook on DockerHub triggers a deployment on Azure
4) With a a minute or two, observe the new app running

### Prerequisites To Running This Yourself

1) Docker Community Edition installed and on your path
2) Java 11 installed - I recommend Amazon Corretto 11.0.5

### Just Run It

Use the `run.sh` script to build the Spring Boot app, build the docker image, and run the docker image.

### Push To DockerHub

Use the `push.sh` script to build and push the docker image to Docker Hub.

This requires authentication to DockerHub.





