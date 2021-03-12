plugins {
    kotlin("multiplatform") apply false
    kotlin("jvm") apply false

    id("com.bmuschko.docker-java-application") apply false
}

group = "ru.otus.kotlin.blogs"
version = rootProject.version

subprojects {
    group = rootProject.group
    version = rootProject.version

    repositories {
        jcenter()
        mavenCentral()
        maven { url = uri("https://dl.bintray.com/kotlin/kotlin-js-wrappers") }
    }

}