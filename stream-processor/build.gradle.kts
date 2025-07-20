plugins {
    java
    id("org.springframework.boot") version "3.5.3"
    id("io.spring.dependency-management") version "1.1.7"
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

group = "com.hyuk84"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":common"))
    implementation("org.springframework.boot:spring-boot-starter:3.5.3")
    implementation("org.springframework.kafka:spring-kafka:3.3.7")
    implementation("org.apache.kafka:kafka-clients:4.0.0")
    implementation("org.apache.kafka:kafka-streams:4.0.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.19.1")
    compileOnly("org.projectlombok:lombok:1.18.38")
    annotationProcessor("org.projectlombok:lombok:1.18.38")
}

tasks.test {
    useJUnitPlatform()
}