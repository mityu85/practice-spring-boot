FROM adoptopenjdk:16-jre-hotspot
RUN mkdir /opt/app
COPY target/kepesitovizsga-gyak-0.0.1-SNAPSHOT.jar /opt/app/kepesitovizsga-gyak.jar
CMD ["java", "-jar", "/opt/app/kepesitovizsga-gyak.jar"]