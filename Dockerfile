#
# Mvn Build
#
FROM maven:3.8.6-eclipse-temurin-17-focal AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Jar Package
#
FROM eclipse-temurin:17-jre-focal
COPY --from=build /home/app/target/hw-0.0.1-SNAPSHOT.jar /Desktop/Backend/vko4/hw.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/Desktop/Backend/vko4/hw.jar"]