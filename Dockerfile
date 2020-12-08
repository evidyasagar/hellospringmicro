
# set the base image
FROM openjdk:8

EXPOSE 8080
ADD target/hellospringboot.jar hellospringboot

ENTRYPOINT ["java","-jar", "/hellospringboot"]