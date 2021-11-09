FROM openjdk:17
RUN mkdir /app
COPY src/test/java/com/epam/testtask/ /app
WORKDIR /app
CMD java MainTest