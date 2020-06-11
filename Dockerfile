FROM adoptopenjdk/openjdk12:latest
EXPOSE 8080
ADD /target/avexadoFarm-0.0.1.jar avexadoFarm.jar

ENTRYPOINT ["java", "-jar", "/avexadoFarm.jar"]