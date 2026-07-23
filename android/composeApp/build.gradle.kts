plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }
    
    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.animation)
            implementation(libs.kotlinx.coroutines.core)
        }
        androidMain.dependencies {
            implementation(libs.androidx.activity.compose)
            implementation(libs.androidx.core.ktx)
        }
    }
}

android {
    namespace = "com.skil.app"
    compileSdk = 36

    signingConfigs {
        create("release") {
            val keyFile = file("skil-release-key.jks")
            if (keyFile.exists()) {
                storeFile = keyFile
                storePassword = "skillifestyle"
                keyAlias = "skilkey"
                keyPassword = "skillifestyle"
            }
        }
    }

    defaultConfig {
        applicationId = "com.skil.app"
        minSdk = 21
        targetSdk = 36
        versionCode = (project.findProperty("versionCode") as? String)?.toInt() ?: 100003
        versionName = (project.findProperty("versionName") as? String) ?: "1.0.3"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            val keyFile = file("skil-release-key.jks")
            if (keyFile.exists()) {
                signingConfig = signingConfigs.getByName("release")
            } else {
                signingConfig = signingConfigs.getByName("debug")
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
