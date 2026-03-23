# PROJEKTI RAHTIIN: H2-databasen kanssa ->
# Build-vaihe
FROM eclipse-temurin:17-jdk-focal AS builder

WORKDIR /opt/app

# Kopioi Mavenin asetukset ja projektin metadata
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN chmod +x ./mvnw

# Lataa riippuvuudet
RUN ./mvnw dependency:go-offline

# Kopioi lähdekoodi
COPY ./src ./src

# Buildaa projekti
RUN ./mvnw clean install -DskipTests

# Kopioi JAR-tiedosto suoraan (ei käytetä find-komentoa)
RUN cp target/*.jar /opt/app/app.jar

# Runtime-vaihe
FROM eclipse-temurin:17-jre-alpine

WORKDIR /opt/app

# Kopioi buildattu JAR-tiedosto
COPY --from=builder /opt/app/app.jar /opt/app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/opt/app/app.jar"]


# PROJEKTI RENDERIIN ->
# # Mvn Build
# #
# FROM maven:3.8.6-eclipse-temurin-17-focal AS build
# COPY src /home/app/src
# COPY pom.xml /home/app
# RUN mvn -f /home/app/pom.xml clean package

# #
# # Jar Package
# #
# FROM eclipse-temurin:17-jre-focal
# COPY --from=build /home/app/target/hw-0.0.1-SNAPSHOT.jar /Desktop/Backend/vko4/hw.jar
# EXPOSE 8080
# ENTRYPOINT ["java", "-jar", "/Desktop/Backend/vko4/hw.jar"]