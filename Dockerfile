FROM eclipse-temurin:17-jdk
WORKDIR /usr/app
COPY target/spring-boot-mysql.jar spring-boot-mysql.jar
ENTRYPOINT ["java","-jar","spring-boot-mysql.jar"]

