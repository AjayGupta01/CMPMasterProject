plugins {
    `kotlin-dsl`
}

dependencies{
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.android.gradle.plugin)
}


gradlePlugin{
    plugins{
        register("cmpKotlinMultiplatform"){
            id = libs.plugins.cmp.kotlinMultiplatform.get().pluginId
            implementationClass = "KotlinMultiplatformConventionPlugin"
        }
        register("cmpAndroidLibrary"){
            id = libs.plugins.cmp.androidLibrary.get().pluginId
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("domainModule"){
            id = libs.plugins.cmp.domainModule.get().pluginId
            implementationClass = "DomainModuleConventionPlugin"
        }
        register("baseAndroidKmpLibrary"){
            id = libs.plugins.cmp.base.android.kmp.library.get().pluginId
            implementationClass = "BaseAndroidKmpLibraryConventionPlugin"
        }
        register("featureModule"){
            id = libs.plugins.cmp.featureModule.get().pluginId
            implementationClass = "FeatureModuleConventionPlugin"
        }
    }
}