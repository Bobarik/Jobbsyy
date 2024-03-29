package plugins

import com.android.build.gradle.LibraryExtension
import com.vlaskorobogatov.koutline.configureAndroidLibrary
import com.vlaskorobogatov.koutline.configureMultiplatformFeature
import com.vlaskorobogatov.koutline.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class FeatureConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply(libs.plugins.multiplatform.get().pluginId)
            apply(libs.plugins.android.library.get().pluginId)
            apply(libs.plugins.buildConfig.get().pluginId)
            apply(libs.plugins.compose.get().pluginId)
            apply(libs.plugins.kotlinx.serialization.get().pluginId)
        }

        extensions.configure<KotlinMultiplatformExtension> {
            configureMultiplatformFeature(libs)
        }

        extensions.configure<LibraryExtension> {
            configureAndroidLibrary()
        }
    }
}
