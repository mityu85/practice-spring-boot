FROM adoptopenjdk:16-jre-hotspot
RUN mkdir /opt/app
COPY target/petshop-0.0.1-SNAPSHOT.jar /opt/app/pet_shop.jar
CMD ["java", "-jar", "/opt/app/pet_shop.jar"]