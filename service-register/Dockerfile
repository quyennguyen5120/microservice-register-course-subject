FROM amazoncorretto:17-alpine AS builder
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY ddd-* ddd-*
RUN chmod +x ./gradlew
RUN ./gradlew bootJar


FROM amazoncorretto:17-alpine
COPY --from=builder build/libs/*.jar app.jar

EXPOSE 1222

ARG SPRING_PROFILES_ACTIVE
RUN echo $SPRING_PROFILES_ACTIVE
ENV SPRING_PROFILES_ACTIVE=$SPRING_PROFILES_ACTIVE


ENTRYPOINT ["java","-jar","/app.jar"]