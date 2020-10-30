
# set the base image
FROM openjdk:8

#add resources to the container
VOLUME /tmp

EXPOSE 8080
# add scripts to the container
ADD target/helloworld.jar helloworld.jar

# install app runtimes and modules
RUN bash -c 'touch /helloworldspring.jar'
RUN apt-get update

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/helloworldspring.jar"]