# 1) BASE IMAGE – hansı əsas şəkil üzərində
FROM openjdk:17-jdk-alpine

# 2) İŞ QOVLUĞU – konteyner içində iş qovluğu təyin et
WORKDIR /app

# 3) KOPYALA – hostdakı faylları konteynerə köçür
#    build/libs/*.jar ShadowJar və ya bootJar ilə build olunmuş jar-ı tapır
COPY build/libs/*.jar app.jar

# 4) ENTRYPOINT – konteyner run edildikdə hansı komanda icra olunacaq
ENTRYPOINT ["java", "-jar", "app.jar"]
