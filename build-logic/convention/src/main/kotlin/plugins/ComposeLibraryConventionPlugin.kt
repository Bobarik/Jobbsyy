package plugins

import Config.ApplicationId
import com.android.build.gradle.LibraryExtension
import com.archipelago.jobbsyy.configureAndroidLibrary
import com.archipelago.jobbsyy.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class ComposeLibraryConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply(libs.plugins.multiplatform.get().pluginId)
            apply(libs.plugins.android.library.get().pluginId)
            apply(libs.plugins.compose.library.get().pluginId)
            apply(libs.plugins.compose.compiler.get().pluginId)
        }

        extensions.configure<KotlinMultiplatformExtension> {
            jvm()
            androidTarget()
            applyDefaultHierarchyTemplate()
        }

        extensions.configure<LibraryExtension> {
            val featureNamespace = "$ApplicationId.${path.split(':')[1]}"
            namespace = featureNamespace
            configureAndroidLibrary()
        }
    }
}
