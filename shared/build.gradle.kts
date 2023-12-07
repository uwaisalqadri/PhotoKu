@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kmp.nativecoroutines)
    alias(libs.plugins.kotlin.serialization)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_11.toString()
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "Shared"
        }
    }

    sourceSets {
        all {
            languageSettings.optIn("kotlinx.cinterop.ExperimentalForeignApi")
            languageSettings.optIn("kotlin.experimental.ExperimentalObjCName")
        }

        commonMain.dependencies {
            implementation(libs.koin.core)

            implementation(libs.ktor.core)
            implementation(libs.ktor.json.serialization)
            implementation(libs.ktor.content.negotiation)
            implementation(libs.ktor.logging)

            implementation(libs.kotlinx.serialization)
            implementation(libs.kotlinx.coroutine)
            implementation(libs.kotlinx.datetime)

            api(libs.kermit.logger)
            api(libs.kmm.viewmodel)
            implementation(kotlin("stdlib-common"))
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
            implementation(libs.koin.test)
            implementation(libs.coroutine.test)

            implementation(libs.mockative.test)
            implementation(libs.kotest.framework.engine)
        }

        androidMain.dependencies {
            implementation(libs.ktor.okhttp)
            implementation(libs.ktor.android)
            implementation(libs.koin.android)
        }

        val androidUnitTest by getting {
            dependencies {
                implementation(libs.junit.test)
                implementation(libs.kotlinx.junit.test)
                implementation(libs.coroutine.test)
                implementation(libs.androidx.core.test)
            }
        }

        iosMain.dependencies {
            implementation(libs.ktor.darwin)
            implementation(libs.ktor.ios)
        }

        iosTest.dependencies {}
    }
}

android {
    val applicationId: String by project
    val compileSdkVersion: String by project
    val minSdkVersion: String by project

    namespace = applicationId
    compileSdk = compileSdkVersion.toInt()
    defaultConfig {
        minSdk = minSdkVersion.toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    sourceSets {
        val main by getting
        main.java.setSrcDirs(listOf("src/androidMain/kotlin"))
        main.res.setSrcDirs(listOf("src/androidMain/res"))
        main.resources.setSrcDirs(
            listOf(
                "src/androidMain/resources",
                "src/commonMain/resources",
            )
        )
        main.manifest.srcFile("src/androidMain/AndroidManifest.xml")
    }
}

dependencies {
    configurations
        .filter { it.name.startsWith("ksp") && it.name.contains("Test") }
        .forEach {
            add(it.name, "io.mockative:mockative-processor:2.0.1")
        }
}