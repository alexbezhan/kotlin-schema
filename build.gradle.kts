import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

version = "0.0.1"

plugins {
    java
    id("org.jetbrains.kotlin.jvm") version "1.4.10" apply false
    kotlin("kapt") version "1.4.10" apply false
}

allprojects {
    repositories {
        mavenCentral()
        jcenter()
        maven { url "https://dl.bintray.com/arrow-kt/arrow-kt/" }
    }

    apply(plugin = "java")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.gradle.application")
    apply(plugin = "org.gradle.idea")
    apply(plugin = "kotlin-kapt")

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
        kotlinOptions.languageVersion = "1.4"
    }
}