import com.android.build.gradle.LibraryExtension
import extensions.getLibs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class FeatureModuleConventionPlugin: Plugin<Project> {
    override fun apply(target: Project): Unit = with(target){
        val libs = getLibs()
        plugins.apply(libs.findPlugin("cmp.kotlinMultiplatform").get().get().pluginId)
        plugins.apply(libs.findPlugin("cmp.androidLibrary").get().get().pluginId)
        plugins.apply(libs.findPlugin("composeMultiplatform").get().get().pluginId)
        plugins.apply(libs.findPlugin("composeCompiler").get().get().pluginId)
        plugins.apply(libs.findPlugin("jetbrains.kotlin.serialization").get().get().pluginId)

        extensions.configure<KotlinMultiplatformExtension> {
            androidTarget {
                @OptIn(ExperimentalKotlinGradlePluginApi::class)
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_17)
                }
            }
            sourceSets.configureEach {
                when(name){
                    "commonMain" -> dependencies{
                       api(libs.findLibrary("kotlinx.serialization.json").get().get())
                    }
                }

            }
        }
        extensions.configure<LibraryExtension> {
            buildFeatures{
                compose = true
            }
        }
    }
}