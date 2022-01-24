import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    application
}

//from gradle.properties
val kotlinJvmTarget: String by project
val tbdCompilerArgs: String by project

group = "me.scicoria"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = kotlinJvmTarget
        freeCompilerArgs = listOf(tbdCompilerArgs)
    }
}

application {
    mainClass.set("MainKt")
}