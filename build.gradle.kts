plugins {
    kotlin("jvm") version "2.2.20"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

application {
    mainClass.set("org.example.MainKt") // adjust to your package and filename
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}