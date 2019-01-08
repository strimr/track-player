FROM openjdk:8-jre-slim

RUN mkdir /app

WORKDIR /app

ADD ./api/target/track-player-api-1.0.0-SNAPSHOT.jar /app

EXPOSE 8080 8443

CMD java -jar track-player-api-1.0.0-SNAPSHOT.jar