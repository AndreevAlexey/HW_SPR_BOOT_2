FROM adoptopenjdk/openjdk11:jdk-11.0.13_8-alpine
EXPOSE 8080
ADD target/HW_SPR_BOOT_2-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "/app.jar"]