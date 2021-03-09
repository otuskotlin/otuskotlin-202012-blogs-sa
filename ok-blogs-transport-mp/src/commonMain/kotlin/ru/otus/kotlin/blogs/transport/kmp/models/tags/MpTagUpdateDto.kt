package ru.otus.kotlin.blogs.transport.kmp.models.tags

import kotlinx.serialization.Serializable
import ru.otus.kotlin.blogs.transport.kmp.models.common.IMpTagUpdateDto

@Serializable
data class MpTagUpdateDto(
    override val name: String?,
    override val id: String?
    ): IMpTagUpdateDto
