
FROM openjdk:8
VOLUME /tmp
EXPOSE 8888
ADD /target/happywagon-0.0.1-SNAPSHOT.jar the-gift-library.jar
ENTRYPOINT ["java", "-jar", "the-gift-library.jar"]
