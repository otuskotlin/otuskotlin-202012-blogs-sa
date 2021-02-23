package ru.otus.kotlin.blogs.transport.kmp.models.common

import kotlinx.serialization.Serializable

@Serializable
enum class MpWorkModeDto {
    PROD,
    TEST
}
