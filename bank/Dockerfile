FROM adoptopenjdk:16-jre-hotspot
RUN mkdir /opt/app
COPY target/bank-0.0.1-SNAPSHOT.jar /opt/app/bank.jar
CMD ["java", "-jar", "/opt/app/bank.jar"]