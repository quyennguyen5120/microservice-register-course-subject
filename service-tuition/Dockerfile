FROM amazoncorretto:17-alpine AS builder
WORKDIR /app
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN ls -alh /app
RUN chmod +x ./gradlew
WORKDIR /app
RUN ./gradlew build


FROM amazoncorretto:17-alpine
COPY --from=builder build/libs/*.jar app.jar

EXPOSE 1223
EXPOSE 6566

ARG SPRING_PROFILES_ACTIVE
RUN echo $SPRING_PROFILES_ACTIVE
ENV SPRING_PROFILES_ACTIVE=$SPRING_PROFILES_ACTIVE


ENTRYPOINT ["java","-jar","/app.jar", "--spring.profiles.active=${SPRING_PROFILES_ACTIVE}"]