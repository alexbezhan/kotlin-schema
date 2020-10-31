import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

version = "0.0.1"

dependencies {
    implementation("org.jetbrains.exposed:exposed-jdbc:0.26.1")
    implementation("org.jetbrains.exposed:exposed-java-time:0.26.1")
    implementation "io.arrow-kt:arrow-core:0.11.0"
    implementation "io.arrow-kt:arrow-core-data:0.11.0"
    implementation "io.arrow-kt:arrow-data:0.8.2"
    implementation "io.arrow-kt:arrow-instances-data:0.8.2"
    implementation "io.arrow-kt:arrow-typeclasses:0.9.0"
    implementation "io.arrow-kt:arrow-core-extensions:0.9.0"
    implementation "io.arrow-kt:arrow-extras-extensions:0.9.0"
    implementation "io.arrow-kt:arrow-instances-core:0.8.2"
    implementation "io.arrow-kt:arrow-extras-data:0.9.0"
    implementation "io.arrow-kt:arrow-annotations:0.11.0"
    implementation "io.arrow-kt:arrow-generic:0.11.0"
    implementation "io.arrow-kt:arrow-syntax:0.11.0"
    implementation "io.arrow-kt:arrow-optics:0.11.0"
    implementation("com.squareup:kotlinpoet:1.7.2")
    annotationProcessor project(":annotation-processor")
    kapt "io.arrow-kt:arrow-meta:0.11.0"
    implementation "org.jetbrains.kotlin:kotlin-stdlib"
}
