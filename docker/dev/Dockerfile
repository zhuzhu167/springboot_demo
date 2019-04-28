FROM registry-vpc.cn-shenzhen.aliyuncs.com/ykthink/spring-boot
COPY app.jar /app/app.jar
ENV JAVA_OPTS=""
EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS -jar /app/app.jar --spring.profiles.active=dev
