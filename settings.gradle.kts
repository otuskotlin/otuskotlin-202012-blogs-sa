rootProject.name = "otuskotlin-blogs"

pluginManagement {
    val kotlinVersion: String by settings
    plugins {
        kotlin("jvm") version kotlinVersion
    }
}

include ("ok-blogs-common-be")