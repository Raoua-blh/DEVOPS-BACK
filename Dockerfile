FROM adoptopenjdk:11-jre-hotspot
WORKDIR /app
ADD target/*.jar Devops-back.jar

EXPOSE 8080
CMD ["java", "-jar", "Devops-back.jar"]
