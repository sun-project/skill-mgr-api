FROM openjdk:8-jdk-alpine

RUN mkdir /application

WORKDIR /application

COPY target/skillMgrApi-0.0.1-SNAPSHOT.jar skillMgrApi.jar

ENTRYPOINT ["java", "-jar", "skillMgrApi.jar"]
