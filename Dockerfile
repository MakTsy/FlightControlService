FROM openjdk:14
ADD target/FlightControlService.jar FlightControlService.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "FlightControlService.jar"]