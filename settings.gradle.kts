rootProject.name = "otuskotlin-blogs"

pluginManagement {
    val kotlinVersion: String by settings
    plugins {
        kotlin("jvm") version kotlinVersion
        kotlin("js") version kotlinVersion apply false
        kotlin("multiplatform") version kotlinVersion apply false
        kotlin("plugin.serialization") version kotlinVersion apply false
    }
}

include("ok-blogs-common-be")
include("ok-blogs-transport-mp")
include("ok-blogs-transport-mapper")
