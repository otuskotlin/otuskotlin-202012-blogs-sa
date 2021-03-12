package ru.otus.config

import io.ktor.routing.*
import ru.otus.controllers.ArticleController

fun Route.articleRoute() {
    val articleController = ArticleController()

    route("/article") {
        post ("/create") { articleController.create(this) }
        post ("/read") { articleController.read(this) }
        post ("/update") { articleController.update(this) }
        post ("/delete") { articleController.delete(this) }
    }
}