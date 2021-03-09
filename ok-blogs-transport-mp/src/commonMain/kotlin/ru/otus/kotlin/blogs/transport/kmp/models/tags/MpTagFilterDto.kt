package ru.otus.kotlin.blogs.transport.kmp.models.tags

import kotlinx.serialization.Serializable
import ru.otus.kotlin.blogs.transport.kmp.models.common.IMpFilterTag

@Serializable
data class MpTagFilterDto(
    override val articleId: String? = null,
    override val tagId: String? = null
    ): IMpFilterTag
