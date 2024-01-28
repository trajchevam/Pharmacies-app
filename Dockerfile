FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/pharmacies-spring-boot-docker.jar /app/app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
