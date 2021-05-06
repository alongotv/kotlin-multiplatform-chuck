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
    jcenter()
    mavenCentral()
}
dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("org.kodein.di:kodein-di-framework-android-x:7.0.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.3")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.5.0")
    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.4.6")

}
android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.alongo.multiplatformchuck.androidApp"
        minSdkVersion(24)
        targetSdkVersion(30)
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