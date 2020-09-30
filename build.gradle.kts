import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.0"
}
group = "dev.maxc"
version = "1.0-TEMPLATE"

repositories {
    mavenCentral()
    maven { setUrl("https://oss.sonatype.org/content/repositories/snapshots") }
}
dependencies {
    testImplementation(kotlin("test-junit"))
    implementation("edu.cmu.sphinx", "sphinx4-core", "5prealpha-SNAPSHOT")
    implementation("edu.cmu.sphinx", "sphinx4-data", "5prealpha-SNAPSHOT")
    implementation(kotlin("stdlib-jdk8"))
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}