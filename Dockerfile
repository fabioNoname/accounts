FROM openjdk
WORKDIR /app
COPY target/accounts-0.0.1-SNAPSHOT.jar /app/accounts.jart
ENTRYPOINT ["java","-jar","/accounts.jar"]