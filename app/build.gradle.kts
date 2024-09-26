plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.artspacemaglatangrodrigon3f"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.artspacemaglatangrodrigon3f"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.ui.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation ("androidx.core:core-ktx:1.10.1")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation ("androidx.activity:activity-compose:1.7.2")

    implementation ("androidx.compose.ui:ui:1.5.1")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.5.1")
    implementation ("androidx.compose.material3:material3:1.2.0-alpha03")
    implementation ("androidx.compose.foundation:foundation:1.5.1")

    implementation ("androidx.compose.material3:material3:1.0.1")
    implementation ("androidx.compose.ui:ui:1.4.0")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.4.0")
    implementation ("androidx.compose.runtime:runtime-livedata:1.4.0")

    debugImplementation ("androidx.compose.ui:ui-tooling:1.5.1")
    debugImplementation ("androidx.compose.ui:ui-test-manifest:1.5.1")

    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:1.5.1")
}