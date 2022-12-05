#this configuration file allows us to take app from intellij, build docker image,
#run as docker container in local machine, then deploy container to AWS

FROM openjdk:17.0.1-jdk-slim
#basically this next line says in my comp's FS, find the target directory
#(target folder directory in program)as well as the .jar file that is in it,
#and save it to var named JAR_FILE
ARG JAR_FILE=target/*.jar
#basically this next line says copy that .jar file, and name it app.jar
COPY ${JAR_FILE} app.jar
#next line then copies it right to the root of the image
ENTRYPOINT ["java","-jar","/app.jar"]