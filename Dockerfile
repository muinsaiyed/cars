FROM openjdk:8
ADD target/cars-0.0.1-SNAPSHOT.jar cars-0.0.1-SNAPSHOT
EXPOSE 8080
ENTRYPOINT ["java","-jar","cars-0.0.1-SNAPSHOT.jar"]