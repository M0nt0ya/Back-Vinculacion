
FROM openjdk:17
ARG JAR_FILE=##########################
COPY ${JAR_FILE} ##########################
ENTRYPOINT ["java", "-jar", "##########################"]