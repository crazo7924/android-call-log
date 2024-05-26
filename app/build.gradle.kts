plugins {
    id("com.android.application")
    id("com.github.sherter.google-java-format") version "0.9"
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(31)

    defaultConfig {
        applicationId = "com.example.task.incoming"
        minSdkVersion(23)
        targetSdkVersion(31)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
            versionNameSuffix = "-release"
        }

        getByName("debug") {
            isMinifyEnabled = false
            versionNameSuffix = "-debug"
        }
    }

    compileOptions {
        targetCompatibility = JavaVersion.VERSION_11
        sourceCompatibility = JavaVersion.VERSION_11
    }


    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    buildToolsVersion = "31.0.0"
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.0.0")

    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.room:room-runtime:2.3.0")
    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.fragment:fragment-ktx:1.3.6")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    kapt("androidx.room:room-compiler:2.3.0")

    implementation("pub.devrel:easypermissions:3.0.0")

    testImplementation("junit:junit:4.13.2")

    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}
