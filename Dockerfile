FROM eclipse-temurin:17-alpine
ADD ./target/*.jar app.jar
CMD touch app.jar
ENTRYPOINT ["java","-Xmx4096m","-Dfile.encoding=UTF-8","-Djava.security.egd=file:/dev/./urandom","-Duser.timezone=Europe/Moscow","-Dspring.config.location=file:/deployments/config/application.yml","-jar","-Dspring.profiles.active=production","app.jar"]