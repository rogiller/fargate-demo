FROM amazoncorretto:11.0.5
VOLUME /tmp
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]


# Docker build commands

# ./gradlew build
# docker build -t rogiller/fargate-demo .
# docker run -p 8080:8080 -t rogiller/fargate-demo