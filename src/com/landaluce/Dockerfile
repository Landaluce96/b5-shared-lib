FROM openjdk

RUN mkdir /app

COPY ../target/*.jar /app/app.jar

COPY ../target/dependency /app/dependency

CMD java -jar /app/app.jar