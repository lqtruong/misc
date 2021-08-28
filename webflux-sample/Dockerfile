FROM openjdk:11
# RUN addgroup -S app_group && adduser -S app_user -G app_group
# USER app_user:app_group
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENV JAVA_OPTS "-Dsun.net.client.defaultConnectTimeout=2000 " \
              "-Dsun.net.client.defaultReadTimeout=20000 " \
              "-XX:+PrintGC " \
              "-XX:+PrintGCTimeStamps " \
              "-XX:+HeapDumpOnOutOfMemoryError " \
              "-XX:HeapDumpPath=/alloc/logs" \
              "-Xms64m -Xmx128m"
ENTRYPOINT ["java","-jar","/app.jar"]

# docker build -t turong/webflux-sample .
# docker run -e "SPRING_PROFILES_ACTIVE=docker" -p 8080:8080 turong/webflux-sample

