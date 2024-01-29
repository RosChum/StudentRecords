# Базовый образ, содержащий java 17
FROM openjdk:17-oracle

#Директория приложеня внутри контейнера
WORKDIR /app

#Копирование JAR-файлов приложения в контейнер
COPY target/StudentRecords-0.0.1-SNAPSHOT.jar app.jar

#Команда для запуска приложения
CMD ["java", "-jar", "app.jar"]

#создание образа docker build -t student-records .
#запуск контейнера docker run --rm -t -i student-records

