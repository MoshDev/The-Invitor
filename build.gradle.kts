import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm") version "1.3.0"
    kotlin("kapt") version "1.3.0"

}
group = "ersan.space"
version = "1.0-SNAPSHOT"

application {
    mainClassName = "MainKt"
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile("com.google.code.gson:gson:2.8.5")
    val daggerVersion = "2.16"
    compile ("com.google.dagger:dagger:$daggerVersion")
    kapt ("com.google.dagger:dagger-compiler:$daggerVersion")

    testCompile("junit:junit:4.12")
    testCompile("org.mockito:mockito-core:2.23.4")
}
repositories {
    mavenCentral()
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}

kapt {
    correctErrorTypes = true
}