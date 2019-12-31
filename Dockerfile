FROM amazoncorretto:8u232
#FROM amazoncorretto:11.0.5

# If you want OpenJDK8
#FROM openjdk:8-jdk-alpine

LABEL maintainer="rogerdiller@gmail.com"

VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=build/libs/*.jar

ADD ${JAR_FILE} app.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
