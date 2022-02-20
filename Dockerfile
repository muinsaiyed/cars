FROM openjdk:12
ADD target/carsApp.jar carsApp.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","carsApp.jar"]