package plugins

import com.android.build.gradle.LibraryExtension
import com.vlaskorobogatov.koutline.configureAndroidLibrary
import com.vlaskorobogatov.koutline.configureCompose
import com.vlaskorobogatov.koutline.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class ComposeLibraryConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply(libs.plugins.multiplatform.get().pluginId)
            apply(libs.plugins.android.library.get().pluginId)
            apply(libs.plugins.compose.get().pluginId)
        }

        extensions.configure<KotlinMultiplatformExtension> {

//            iosX64()
//            iosArm64()
//            iosSimulatorArm64()
            jvm()
            androidTarget()
            applyDefaultHierarchyTemplate()
        }

        extensions.configure<LibraryExtension> {
            configureAndroidLibrary()
            configureCompose(libs)
        }
    }
}
