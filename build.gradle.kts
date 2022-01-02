buildscript {

    val kotlin_version = "1.6.10"

    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.0")
        classpath("com.android.tools.build:gradle:7.0.4")
        classpath(kotlin("gradle-plugin", kotlin_version))
    }
}
group = "com.alongo.multiplatformchuck"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
