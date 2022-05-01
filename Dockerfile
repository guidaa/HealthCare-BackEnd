FROM openjdk:14-jdk-alpine
ADD target/spring-boot-ecommerce.jar spring-boot-ecommerce.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","spring-boot-ecommerce.jar"]
