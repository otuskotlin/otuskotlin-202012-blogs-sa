package ru.otus.kotlin.blogs.transport.kmp.models.articles

import kotlinx.serialization.Serializable
import ru.otus.kotlin.blogs.transport.kmp.models.common.IMpFilterArticle

@Serializable
data class MpArticleFilterDto(
    override val categoryId: String? = null,
    override val tagId: String? = null
    ): IMpFilterArticle
