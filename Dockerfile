FROM eclipse-temurin:17
WORKDIR /home
COPY ./target/arithmetic-service-0.0.1-SNAPSHOT.jar arithmetic-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "arithmetic-service.jar"]
