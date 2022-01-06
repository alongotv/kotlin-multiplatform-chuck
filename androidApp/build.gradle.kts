plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-parcelize")
}
group = "com.alongo.multiplatformchuck"
version = "1.0-SNAPSHOT"

repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
}
dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.2")
    implementation("org.kodein.di:kodein-di-framework-android-x:7.10.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.3")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.6.10")
    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.4.6")

    testImplementation("org.jetbrains.kotlin:kotlin-test:1.6.10")
}

android {
    compileSdk = 31
    defaultConfig {
        applicationId = "com.alongo.multiplatformchuck.androidApp"
        minSdk = 24
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}