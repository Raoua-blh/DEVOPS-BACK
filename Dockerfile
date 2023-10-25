FROM adoptopenjdk:11-jre-hotspot
WORKDIR /app
ADD target/*.jar Devops-backend.jar

EXPOSE 8080
CMD ["java", "-jar", "Devops-backend.jar"]
