# 第一阶段：编译打包
# 使用 Maven 镜像进行构建
FROM maven:3.8.4-openjdk-17-slim AS build

# 设置工作目录
WORKDIR /app

# 将本地代码复制到容器中
COPY . .

# 执行 Maven 打包命令，跳过测试
RUN mvn package -DskipTests

# 第二阶段：运行
# 使用轻量级的 JRE 镜像
FROM openjdk:17-jdk-alpine

WORKDIR /app

# 从第一阶段（build）的 target 目录中复制生成的 jar 包
COPY --from=build /app/target/*.jar app.jar

# 暴露端口
EXPOSE 80

# 启动命令
ENTRYPOINT ["java", "-jar", "/app/app.jar"]