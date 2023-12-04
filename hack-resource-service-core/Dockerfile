FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/hack-resource-service-core-1.0.0.jar hack-resource-service-core.jar
RUN sh -c 'touch /hack-resource-service-core.jar'
EXPOSE 40001
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -jar /hack-resource-service-core.jar