FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY . .

# ✅ Fix permission issue
RUN chmod +x mvnw

# ✅ Build the project
RUN ./mvnw clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/studentshub-1.0.0.jar"]