FROM eclipse-temurin:17
WORKDIR /home
COPY ./target/arithmetic-service-0.0.1-SNAPSHOT.jar arithmetic-service.jar
ENTRYPOINT ["java", "-jar", "arithmetic-service.jar"]
