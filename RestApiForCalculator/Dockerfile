FROM openjdk:8-jdk-alpine

WORKDIR /app

COPY target/RestApiForCalculator-0.0.1-SNAPSHOT.jar /app/calculator.jar

EXPOSE 8080

# Define environment variables
#ENV SPRING_DATASOURCE_URL=jdbc:mysql://db:3306/calci_request?allowPublicKeyRetrieval=true
#ENV SPRING_DATASOURCE_USERNAME=root
#ENV SPRING_DATASOURCE_PASSWORD=root

CMD ["java", "-jar", "calculator.jar"]






