package ru.otus.kotlin.blogs.common.validation

data class ValidationDefaultError(
    override val message: String
    ) : IValidationError
