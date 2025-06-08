FROM maven:3.8.4-openjdk-17-slim AS builder
WORKDIR /workspace

COPY pom.xml .
COPY wallet-core/pom.xml wallet-core/
COPY balance-service/pom.xml balance-service/

RUN mvn -B dependency:go-offline

# Copiar todo o código fonte dos módulos
COPY wallet-core/ wallet-core/
COPY balance-service/ balance-service/

RUN mvn -B clean package -pl balance-service -am -DskipTests

FROM eclipse-temurin:17-jdk-jammy AS runtime
WORKDIR /app

COPY --from=builder /workspace/balance-service/target/*.jar app.jar

EXPOSE 3003

ENTRYPOINT ["java", "-jar", "app.jar"]
