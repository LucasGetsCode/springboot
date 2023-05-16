FROM amazoncorretto:17

MAINTAINER lucaspujia

COPY backendviejo-0.0.1-SNAPSHOT.jar backendviejo-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","backendviejo-0.0.1-SNAPSHOT.jar"]
