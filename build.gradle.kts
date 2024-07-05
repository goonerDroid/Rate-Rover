// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.spotless)
    alias(libs.plugins.kotlinSerialization) apply false
    alias(libs.plugins.hilt.gradlePlugin) apply false
}

subprojects {
    apply(plugin = "com.diffplug.spotless")

    spotless {
        kotlin {
            target("**/*.kt")
            targetExclude("$buildDir/**/*.kt")
            targetExclude("bin/**/*.kt")
            licenseHeaderFile(rootProject.file("spotless/copyright.kt"))
        }
    }
}
