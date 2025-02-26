FROM openjdk
COPY target/*.jar /app/

WORKDIR /app
CMD ["java", "-jar", "calculator-1.jar"]
