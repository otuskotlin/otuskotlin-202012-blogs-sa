package ru.otus.kotlin.blogs.common.validation

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import ru.otus.kotlin.blogs.common.validation.validators.ValidatorStringSingleLanguage
import kotlin.test.assertEquals

internal class ValidatorStringSingleLanguageTest {

    @ParameterizedTest
    @CsvSource(
    "true,abct",
    "true,абвгд",
    "false,abаб")
    fun singleLanguageValidationTest(expectedResult : Boolean, value : String) {
        val validator = ValidatorStringSingleLanguage()
        val res = validator validate value
        assertEquals(expectedResult, res.isSuccess)
    }
}