package ru.otus.kotlin.blogs.common.validation.validators

import ru.otus.kotlin.blogs.common.validation.IValidator
import ru.otus.kotlin.blogs.common.validation.ValidationDefaultError
import ru.otus.kotlin.blogs.common.validation.ValidationResult

class ValidatorStringSingleLanguage : IValidator<String> {

    override fun validate(value: String): ValidationResult {
        return if(value.IsRussianLetterContain() && value.IsEnglishLetterContain()) {
            ValidationResult(
                errors = listOf(
                    ValidationDefaultError(
                        message = "Word can't contain russian and english letter together"
                    )
                )
            )
        } else {
            ValidationResult.SUCCESS
        }
    }

    fun String.IsRussianLetterContain() : Boolean {
        return Regex("[а-яА-ЯёЁ]").containsMatchIn(this)
    }

    fun String.IsEnglishLetterContain() : Boolean {
        return Regex("[a-zA-Z]").containsMatchIn(this)
    }
}