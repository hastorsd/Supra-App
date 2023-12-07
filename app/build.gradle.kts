plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.supraapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.supraapp"
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
    // RecycleView
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    // For control over item selection of both touch and mouse driven selection
    implementation("androidx.recyclerview:recyclerview-selection:1.1.0")

    // Coroutine Lifecycle Scopes
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    //Glide
    implementation ("com.github.bumptech.glide:glide:4.14.1")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.13.2")

    implementation ("de.hdodenhof:circleimageview:3.1.0")

    //coroutines
    val coroutines_version = "1.3.9"

    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version")

    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version")

    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:$coroutines_version")

    //Coroutine View Model Scope.
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.1.0")

    // Dependency Injection
    implementation ("io.insert-koin:koin-android:3.1.2")


    //dagger hilt
    implementation("com.google.dagger:hilt-android:2.44.2")
    kapt("com.google.dagger:hilt-android-compiler:2.44.2")

    // hilt viewModel extension
    val hilt_jetpack_version = "1.0.0-alpha01"

    //noinspection GradleDependency

    kapt ("androidx.hilt:hilt-compiler:$hilt_jetpack_version")

    //lifeCycle
    //Lifecycle
    val lifecycle_version = "2.6.2"
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")

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

    //Navigation Component
    val nav_version = "2.7.4"
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    //Room
    implementation("androidx.room:room-runtime:2.6.0")
    kapt("androidx.room:room-compiler:2.6.0")
    implementation("androidx.room:room-ktx:2.6.0")

    //Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    //Dependecy Injection
    implementation("io.insert-koin:koin-android:3.1.2")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")

}
