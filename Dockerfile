FROM openjdk:11
ARG JAR_FILE=target/orange-talents-05-projeto-proposta-0.0.1-SNAPSHOT.jar
COPY ./target/orange-talents-05-projeto-proposta-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","orange-talents-05-projeto-proposta-0.0.1-SNAPSHOT.jar"]