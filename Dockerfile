FROM openjdk:21-jdk-slim

RUN apt-get update \
 && apt-get install -y ffmpeg \
 && rm -rf /var/lib/apt/lists/*

RUN mkdir -p /app/uploads /app/outputs

VOLUME /tmp

# JAR 복사
ARG JAR_FILE=build/libs/Garlic-Holic-Backend-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# Google 인증 키 파일 포함
COPY google-credentials.json /app/google-credentials.json

# 환경변수로 인증 경로 설정 (Spring Boot 등에서 사용 가능)
ENV GOOGLE_APPLICATION_CREDENTIALS=/app/google-credentials.json

ENTRYPOINT ["java", "-jar", "/app.jar"]