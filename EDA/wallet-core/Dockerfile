FROM maven:3.8.4-openjdk-17-slim AS builder
WORKDIR /workspace

COPY pom.xml .
COPY wallet-core/pom.xml wallet-core/
COPY balance-service/pom.xml balance-service/

RUN mvn -B dependency:go-offline

COPY wallet-core/ wallet-core/
COPY balance-service/ balance-service/

RUN mvn -B clean package -pl wallet-core -am -DskipTests

FROM eclipse-temurin:17-jdk-jammy AS runtime
WORKDIR /app

COPY --from=builder /workspace/wallet-core/target/*.jar app.jar

EXPOSE 3001

ENTRYPOINT ["java", "-jar", "app.jar"]
