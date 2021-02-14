package ru.otus.kotlin.blogs.common.validation

import ru.otus.kotlin.blogs.common.validation.validators.ValidatorStringSingleLanguage
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class ValidatorStringSingleLanguageTest {

    @Test
    fun successEnglishValidationTest() {
        val validator = ValidatorStringSingleLanguage()
        val res = validator validate "abcdefg"
        assertEquals(true, res.isSuccess)
    }

    @Test
    fun successRussianValidationTest() {
        val validator = ValidatorStringSingleLanguage()
        val res = validator validate "абвгдеёж"
        assertEquals(true, res.isSuccess)
    }

    @Test
    fun failedMixedValidationTest() {
        val validator = ValidatorStringSingleLanguage()
        val res = validator validate "абвcdefg"
        assertEquals(false, res.isSuccess)
        assertTrue {
            res.errors.first().message.contains("together")
        }
    }
}