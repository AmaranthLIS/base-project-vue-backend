FROM openjdk:14-alpine
RUN apk --no-cache add curl
EXPOSE 9080
COPY build/libs/*-all.jar server.jar
CMD java ${JAVA_OPTS} -jar server.jar
