plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    kotlin("kapt")
}

android {
    namespace = "com.example.jokesapidemo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.jokesapidemo"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    viewBinding {
        enable = true
    }

    dataBinding {

        enable = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)

    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.navigation.ui.ktx)
    //Architectural Component
    implementation(libs.room.ktx)
    //noinspection KaptUsageInsteadOfKsp
    implementation(libs.room.runtime)
    kapt(libs.room.compiler.kapt)
    kapt(libs.lifecycle.compiler.kapt)


            implementation(libs.coroutinesCore)
            implementation (libs.coroutinesAndroid )
}