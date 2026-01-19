plugins {
    alias(libs.plugins.cmp.featureModule)
}

kotlin {

    sourceSets {

        androidMain.dependencies {
            api(compose.preview)
            api(libs.androidx.activity.compose)
            api(libs.bundles.koin.android)
            api(libs.kotlinx.coroutines.android)
        }
        commonMain.dependencies {
            api(compose.runtime)
            api(compose.foundation)
            api(compose.material3)
            api(compose.ui)
            api(compose.materialIconsExtended)
            api(compose.components.resources)
            api(compose.components.uiToolingPreview)
            api(libs.androidx.lifecycle.viewmodel)
            api(libs.androidx.lifecycle.runtimeCompose)

            api(libs.bundles.koin.shared)

            api(libs.bundles.coil)
        }
        commonTest.dependencies {
            api(libs.kotlin.test)
        }
    }
}


dependencies {
    debugApi(compose.uiTooling)
}
compose.resources {
    publicResClass = true
    packageOfResClass = "org.udbhav.core.ui.resources"
    generateResClass = always
}

