FROM openjdk:8
VOLUME /home/abarahona/tmp
EXPOSE 8080
ARG JAR_FILE=target/searchclassifieds-1.0.0-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
