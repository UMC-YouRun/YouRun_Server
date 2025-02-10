FROM eclipse-temurin:17-jdk-ubi9-minimal

RUN microdnf install -y findutils
# 작업 디렉토리 설정
WORKDIR /app

# Gradle Wrapper 및 프로젝트 의존성 복사
COPY gradlew build.gradle settings.gradle ./
COPY gradle ./gradle
RUN chmod +x gradlew

# 소스 코드 복사 후 빌드 실행
COPY . .
RUN ./gradlew clean build -x test --no-daemon

# 생성된 JAR 파일을 실행할 수 있도록 복사
RUN cp build/libs/yourun-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]