### Multi-Staged build ### 
# FIRST STAGE - BUILD STAGE: 
# base image and maven build
FROM maven:3.6.3-openjdk-11-slim AS build

# copy the app into the selected directory by the path 
COPY . /usr/home/src/app

# Create an executable jar executing mvn package command 
RUN mvn -f /usr/home/src/app/javaindocker/pom.xml clean package

# Create an user to access the container as not root 
RUN useradd -ms /bin/bash 1001

# Set specifications user 1001
USER 1001
WORKDIR $HOME/app/javaindocker

# SECOND STAGE - PACKAGE STAGE:
# In this stage we will run the jar that contains the app

# Choose an image with the jdk 11
# The slim image is a paired down version of the full image. This image generally only installs the minimal
# packages needed to run your particular tool.
FROM openjdk:11.0-jre-slim-buster

# Specifications of the content of the container
LABEL "edu.pingpong.romansgohome"="Romans Go Home Regex Kata" \
        version="1.0" \
        description="Kata with Regex in Java" \ 
        maintainer="pllinas@cifpfbmoll.eu"

# Select the working directory of the app
WORKDIR $HOME/app/javaindocker

# copy the jar from the stage build to the working directory with docker 
COPY --from=build /usr/home/src/app/javaindocker/target/*.jar ./romansgohome.jar

# when execute docker container execute this commands and run the application
ENTRYPOINT ["java", "-jar", "romansgohome.jar"]
