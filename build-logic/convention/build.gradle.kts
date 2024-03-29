import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.vlaskorobogatov.koutline"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.ksp.gradle.plugin)
    compileOnly(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("application") {
            id = "koutline.application"
            implementationClass = "plugins.ApplicationConventionPlugin"
        }
        register("feature") {
            id = "koutline.feature"
            implementationClass = "plugins.FeatureConventionPlugin"
        }
        register("library") {
            id = "koutline.library"
            implementationClass = "plugins.LibraryConventionPlugin"
        }
        register("composeLibrary") {
            id = "koutline.library.compose"
            implementationClass = "plugins.ComposeLibraryConventionPlugin"
        }
    }
}
