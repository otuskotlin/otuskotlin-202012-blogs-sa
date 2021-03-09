package ru.otus.kotlin.blogs.transport.kmp.models.tags

import kotlinx.serialization.Serializable
import ru.otus.kotlin.blogs.transport.kmp.models.common.IMpTagCreateDto

@Serializable
data class MpTagCreateDto(override val name: String?): IMpTagCreateDto
