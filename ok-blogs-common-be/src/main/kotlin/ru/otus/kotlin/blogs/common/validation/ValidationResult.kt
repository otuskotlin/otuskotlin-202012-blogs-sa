package ru.otus.kotlin.blogs.common.validation

import java.util.Collections.emptyList

class ValidationResult (val errors: List<IValidationError>) {
    val isSuccess : Boolean
        get() = errors.isEmpty()

    companion object {
        val SUCCESS = ValidationResult(emptyList())
    }
}
