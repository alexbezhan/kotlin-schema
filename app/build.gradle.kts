import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

version = "0.0.1"

kapt {
    generateStubs = true
}

sourceSets {
    main {
        kotlin
    }
}

val generatedSourcesDir = file("$buildDir/generated/src")

sourceSets["main"].withConvention(org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet::class) {
    kotlin.srcDir(generatedSourcesDir)
}

dependencies {
    kapt(project(":annotation-processor"))
    compileOnly(project(":annotation-processor"))
    kapt("io.arrow-kt:arrow-meta:0.11.0")
}
