import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }
    
    jvm("desktop")
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true

            export(libs.decompose.decompose)
            export(libs.essenty.lifecycle)
            export(libs.mvikotlin.main)
            export(libs.mvikotlin.mvikotlin)
        }
    }
    
    sourceSets {
        val desktopMain by getting
        
        androidMain.dependencies {
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.androidx.media3.exoplayer)
            implementation(libs.androidx.media3.exoplayerDash)
            implementation(libs.androidx.media3.ui)
            runtimeOnly(libs.kotlinx.coroutines.android)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            api(libs.decompose.decompose)
            implementation(libs.decompose.extensions.compose)
            api(libs.essenty.lifecycle)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.datetime)
            implementation(libs.mvikotlin.extensions.coroutines)
            api(libs.mvikotlin.main)
            api(libs.mvikotlin.mvikotlin)
            implementation(projects.shared)
        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.caprica.vlcj)
            runtimeOnly(libs.kotlinx.coroutines.swing)
        }
    }
}

android {
    namespace = "com.chipmunksmedia.helldivers.remote"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "com.chipmunksmedia.helldivers.remote"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = libs.versions.versionCode.get().toInt()
        versionName = libs.versions.versionName.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    dependencies {
        debugImplementation(libs.compose.ui.tooling)
    }
}

compose.desktop {
    application {
        mainClass = "com.chipmunksmedia.helldivers.remote.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Msi, TargetFormat.Deb)
            packageName = "com.chipmunksmedia.helldivers.remote"

            packageVersion = libs.versions.versionName.get()
        }

        nativeDistributions {
            targetFormats(TargetFormat.Dmg)
            packageName = "com.chipmunksmedia.helldivers.remote"

            // Use modified version for Dmg to avoid "Illegal version for 'Dmg'" issue
            // Tracked in https://github.com/JetBrains/compose-multiplatform/issues/2360
            packageVersion = libs.versions.versionNameDmg.get()
        }
    }
}
