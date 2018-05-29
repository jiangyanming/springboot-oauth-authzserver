FROM java:8
MAINTAINER Arnab Ray <ray.arnab.82@gmail.com>

ENV SB_WORKDIR    "/opt/spring-boot"
ENV SB_PORT  "8081"

VOLUME /tmp

RUN mkdir -p ${SB_WORKDIR}
WORKDIR ${SB_WORKDIR}

#ARG JAR_FILE
#ADD target/${JAR_FILE} ./oauth-demo-app.jar

ADD target/springboot-oauthdemo-0.0.1-SNAPSHOT.jar ./oauth-demo-app.jar

EXPOSE ${SB_PORT}
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","./oauth-demo-app.jar"]