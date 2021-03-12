package ru.otus.config

import io.ktor.routing.*
import ru.otus.controllers.CategoryController

fun Route.categoryRoute() {
    val categoryController = CategoryController()

    route("/category") {
        post ("/create") { categoryController.create(this) }
        post ("/read") { categoryController.read(this) }
        post ("/update") { categoryController.update(this) }
        post ("/delete") { categoryController.delete(this) }
    }
}