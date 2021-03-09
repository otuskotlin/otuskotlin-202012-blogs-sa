plugins {
    kotlin("jvm")
}

group = rootProject.group
version = rootProject.version

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":ok-blogs-common-be"))
    implementation(project(":ok-blogs-transport-mp"))

    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))
}
