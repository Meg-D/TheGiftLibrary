
FROM openjdk:8
VOLUME /tmp
EXPOSE 8888
ADD /target/happywagon-0.0.1-SNAPSHOT.jar the-gift-library.jar
RUN mkdir ./happywagon_images
RUN mkdir ./happywagon_images/artist_images
RUN mkdir ./happywagon_images/product_images
RUN mkdir ./happywagon_images/category_images
RUN mkdir ./happywagon_images/categoryRequest_images
ENTRYPOINT ["java", "-jar", "the-gift-library.jar"]
