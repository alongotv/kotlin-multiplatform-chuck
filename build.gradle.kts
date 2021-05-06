buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.0")
        classpath("com.android.tools.build:gradle:4.2.0")
    }
}
group = "com.alongo.multiplatformchuck"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
