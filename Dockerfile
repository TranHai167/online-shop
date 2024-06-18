# Sử dụng hình ảnh Maven chính thức để xây dựng dự án
FROM maven:3.8.6-openjdk-11 AS build

# Đặt thư mục làm việc trong container
WORKDIR /app

# Sao chép file cấu hình và các dependencies của dự án vào container
COPY pom.xml .

# Tải về các dependencies được khai báo trong pom.xml
RUN mvn dependency:go-offline

# Sao chép toàn bộ mã nguồn của dự án vào container
COPY src ./src
COPY images ./images

# Xây dựng dự án, tạo ra file JAR
RUN mvn package -DskipTests

# Sử dụng hình ảnh OpenJDK chính thức để chạy ứng dụng
FROM openjdk:11-jre-slim

# Đặt thư mục làm việc trong container
WORKDIR /app

# Sao chép file JAR từ bước build vào container
COPY --from=build /app/target/*.jar app.jar

# Expose cổng ứng dụng (thay đổi cổng này nếu ứng dụng của bạn sử dụng cổng khác)
EXPOSE 8080

# Chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]
