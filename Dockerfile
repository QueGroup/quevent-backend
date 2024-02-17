FROM openjdk:17-oracle
WORKDIR /app
COPY --from=builder /app/target/*.jar /app/*.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/*.jar"]