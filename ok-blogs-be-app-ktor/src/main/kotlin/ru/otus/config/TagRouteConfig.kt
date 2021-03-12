package ru.otus.config

import io.ktor.routing.*
import ru.otus.controllers.TagController

fun Route.tagRoute() {
    val tagController = TagController()

    route("/tag") {
        post ("/create") { tagController.create(this) }
        post ("/read") { tagController.read(this) }
        post ("/update") { tagController.update(this) }
        post ("/delete") { tagController.delete(this) }
    }
}