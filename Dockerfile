FROM java:8-jdk-alpine
ADD ./build/libs/*.jar opt/aes-demo-0.0.1-SNAPSHOT.jar
ENV SPRING_PROFILE="to be overridden from yaml"
ENV JAVA_OPTS=""
WORKDIR /opt/
ENTRYPOINT exec java $JAVA_OPTS -jar aes-demo-0.0.1-SNAPSHOT.jar