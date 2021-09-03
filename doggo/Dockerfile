FROM adoptopenjdk:16-jre-hotspot
RUN mkdir /opt/app
COPY target/doggo-0.0.1-SNAPSHOT.jar /opt/app/doggo.jar
CMD ["java", "-jar", "/opt/app/doggo.jar"]