FROM maven:3.9.6-amazoncorretto-17 AS build

COPY src /app/src
COPY pom.xml /app

WORKDIR /app
RUN mvn clean package -DskipTests

FROM amazoncorretto:17

COPY --from=build /app/target/link.shortener-0.0.1-SNAPSHOT.jar /app/app.jar

WORKDIR /app

EXPOSE 9999

CMD ["java", "-jar", "app.jar"]