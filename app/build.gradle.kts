plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.supraapp"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.supraapp"
        minSdk = 24
        targetSdk = 33
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Kotlin
    val nav_version = "2.5.3"
    implementation ("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation ("androidx.navigation:navigation-ui-ktx:$nav_version")

    //coroutines
    val coroutines_version = "1.3.9"

    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version")

    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version")

    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:$coroutines_version")

    //dagger hilt
    implementation("com.google.dagger:hilt-android:2.44.2")
    kapt("com.google.dagger:hilt-android-compiler:2.44.2")

    // hilt viewModel extension
    val hilt_jetpack_version = "1.0.0-alpha01"

    //noinspection GradleDependency
    implementation ("androidx.hilt:hilt-lifecycle-viewmodel:$hilt_jetpack_version")

    kapt ("androidx.hilt:hilt-compiler:$hilt_jetpack_version")

    //lifeCycle
    val lifecycle_version = "2.4.0-alpha01"

    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")

    implementation ("androidx.lifecycle:lifecycle-common-java8:$lifecycle_version")

    //viewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")

    //liveData
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")

    //by viewModels
    implementation ("androidx.fragment:fragment-ktx:1.3.3")

    //validation of input
    implementation ("com.mobsandgeeks:android-saripaar:2.0.3")

    //preferences DataStore
    implementation ("androidx.datastore:datastore-preferences:1.0.0-beta01")

    //viewBinding
    implementation ("com.android.databinding:viewbinding:4.1.3")

    //room
    val room_version = "2.3.0"

    //noinspection GradleDependency
    implementation ("androidx.room:room-runtime:$room_version")
    kapt ("androidx.room:room-compiler:$room_version")

    //noinspection GradleDependency
    implementation ("androidx.room:room-ktx:$room_version")
}

kapt {
    correctErrorTypes = true
}