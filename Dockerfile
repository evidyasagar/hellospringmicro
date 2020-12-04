
# set the base image
FROM openjdk:8

EXPOSE 8080
ADD target/hellospring.jar hellospring

ENTRYPOINT ["java","-jar", "/hellospring"]