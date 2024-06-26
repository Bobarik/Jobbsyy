package com.archipelago.jobbsyy

import org.gradle.accessors.dm.LibrariesForLibs
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

fun KotlinMultiplatformExtension.configureMultiplatformFeature(
    libs: LibrariesForLibs
) {
    androidTarget()
    jvm()
    applyDefaultHierarchyTemplate()

    sourceSets.apply {
        commonMain.dependencies {
            implementation(project(":core:arch"))
            implementation(project(":core:navigation"))

            implementation(libs.napier)
            implementation(libs.kotlinx.coroutines.core)

            implementation(project.dependencies.platform(libs.koin.bom))
            implementation(libs.koin.core)
            implementation(libs.koin.compose)

            implementation(libs.decompose)
            implementation(libs.decompose.compose)

            implementation(libs.orbit.core)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }

        androidMain.dependencies {
            implementation(libs.koin.android)

            implementation(libs.compose.uitooling)
            implementation(libs.kotlinx.coroutines.android)
        }
    }
}
