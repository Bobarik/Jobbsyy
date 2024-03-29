package plugins

import com.android.build.api.dsl.ApplicationExtension
import com.vlaskorobogatov.koutline.configureAndroidApplication
import com.vlaskorobogatov.koutline.configureMultiplatformApplication
import com.vlaskorobogatov.koutline.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class ApplicationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply(libs.plugins.multiplatform.get().pluginId)
            apply(libs.plugins.compose.get().pluginId)
            apply(libs.plugins.android.application.get().pluginId)
            apply(libs.plugins.buildConfig.get().pluginId)
            apply(libs.plugins.kotlinx.serialization.get().pluginId)
        }

        extensions.configure<KotlinMultiplatformExtension> {
            configureMultiplatformApplication(libs)
        }

        extensions.configure<ApplicationExtension> {
            configureAndroidApplication(libs)
        }
    }
}
