FROM openjdk:17-alpine
VOLUME /tmp
EXPOSE 8080
ADD target/RatingManagementSystem-0.0.1-SNAPSHOT.jar RatingManagementSystem.jar
ENTRYPOINT ["java","-jar","/RatingManagementSystem.jar"]