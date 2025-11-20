plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
} //앱용 플러그인  

android {
    namespace = "com.example.storagebench"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.storagebench"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
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

    // 여기서 DataBinding은 OFF, ViewBinding은 ON
    buildFeatures {
        viewBinding = true
        dataBinding = false
    }
} //앱설정

dependencies {
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.activity:activity-ktx:1.9.2")
} //안드로이드 기본 라이브러리 추가
