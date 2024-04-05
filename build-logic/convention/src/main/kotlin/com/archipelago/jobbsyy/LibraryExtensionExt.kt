package com.archipelago.jobbsyy

import Config.CompileSdk
import Config.JavaVersion
import Config.MinSdk
import com.android.build.gradle.LibraryExtension
import org.gradle.kotlin.dsl.get

fun LibraryExtension.configureAndroidLibrary() {
    compileSdk = CompileSdk

    defaultConfig.minSdk = MinSdk

    compileOptions {
        sourceCompatibility = JavaVersion
        targetCompatibility = JavaVersion
    }

    sourceSets["main"].apply {
        manifest.srcFile("src/androidMain/AndroidManifest.xml")
        res.srcDirs("src/androidMain/resources")
    }

    buildTypes {
        release {
            isMinifyEnabled = true

            signingConfig = signingConfigs.getByName("debug")

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion
        targetCompatibility = JavaVersion
    }
}
