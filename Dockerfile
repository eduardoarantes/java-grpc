FROM maven:3.6-jdk-11-slim as build

WORKDIR /root

COPY ./pom.xml /root/pom.xml
RUN mvn dependency:go-offline -B --fail-never

COPY ./src /root/src
RUN mvn package -Dmaven.test.skip=true -DskipTests

FROM openjdk:11-jre-slim

RUN mkdir /app
WORKDIR /app
COPY --from=build /root/target/grpc-1.3.jar grpc-1.3.jar


CMD [ "java", "-jar", "grpc-1.3.jar" ]
