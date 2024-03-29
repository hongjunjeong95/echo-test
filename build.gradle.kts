import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.1.5"
    id("io.spring.dependency-management") version "1.1.3"
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.8.22"
    kotlin("plugin.jpa") version "1.8.22"
}

group = "echo"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}


repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    // dev tools
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // core
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // data
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-mysql")
    implementation("com.vladmihalcea:hibernate-types-60:2.20.0")
    runtimeOnly("com.mysql:mysql-connector-j")
    implementation("au.com.console:kassava:2.1.0")

    // swagger
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")

    // security
    implementation("org.springframework.boot:spring-boot-starter-security:3.1.5")


    // validation
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
