plugins {
    id("com.android.application")
}

android {
    namespace = "com.aymu.calculator"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.aymu.calculator"
        minSdk = 23
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    externalNativeBuild {
        cmake {
            path = file("../CMakeLists.txt")
        }
    }
}
