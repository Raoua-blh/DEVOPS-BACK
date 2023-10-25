FROM adoptopenjdk:11-jre-hotspot
WORKDIR /app
COPY target/DevOps_Project-1.0.jar Devops-backend.jar
EXPOSE 8080
CMD ["java", "-jar", "Devops-backend.jar"]
