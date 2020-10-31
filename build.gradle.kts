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
        maven("https://dl.bintray.com/arrow-kt/arrow-kt/")
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

subprojects {
    dependencies {
        implementation("org.jetbrains.exposed:exposed-jdbc:0.26.1")
        implementation("org.jetbrains.exposed:exposed-java-time:0.26.1")
        implementation("io.arrow-kt:arrow-core:0.11.0")
        implementation("io.arrow-kt:arrow-core-data:0.11.0")
        implementation("io.arrow-kt:arrow-data:0.8.2")
        implementation("io.arrow-kt:arrow-instances-data:0.8.2")
        implementation("io.arrow-kt:arrow-typeclasses:0.9.0")
        implementation("io.arrow-kt:arrow-core-extensions:0.9.0")
        implementation("io.arrow-kt:arrow-extras-extensions:0.9.0")
        implementation("io.arrow-kt:arrow-instances-core:0.8.2")
        implementation("io.arrow-kt:arrow-extras-data:0.9.0")
        implementation("io.arrow-kt:arrow-annotations:0.11.0")
        implementation("io.arrow-kt:arrow-generic:0.11.0")
        implementation("io.arrow-kt:arrow-syntax:0.11.0")
        implementation("io.arrow-kt:arrow-optics:0.11.0")
        implementation("com.squareup:kotlinpoet:1.7.2")
        implementation("org.jetbrains.kotlin:kotlin-stdlib")
    }
}