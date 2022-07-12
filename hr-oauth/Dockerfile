FROM openjdk:11
VOLUME /tmp
ADD ./target/hr-oauth-1.0-SNAPSHOT.jar hr-oauth.jar
ENTRYPOINT ["java","-jar","/hr-oauth.jar"]