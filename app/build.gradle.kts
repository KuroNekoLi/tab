plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.tab"
    compileSdkPreview = "UpsideDownCake"

    defaultConfig {
        applicationId = "com.example.tab"
        minSdkPreview = 29.toString()
        targetSdkPreview = 29.toString()
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.leanback:leanback:1.0.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation ("androidx.leanback:leanback:1.2.0-alpha02")
    implementation ("androidx.leanback:leanback-tab:1.1.0-beta01")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
}