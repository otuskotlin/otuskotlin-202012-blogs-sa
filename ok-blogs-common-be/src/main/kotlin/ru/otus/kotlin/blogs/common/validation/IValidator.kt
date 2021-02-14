package ru.otus.kotlin.blogs.common.validation

interface IValidator<T> {
    infix fun validate(value : T): ValidationResult
}