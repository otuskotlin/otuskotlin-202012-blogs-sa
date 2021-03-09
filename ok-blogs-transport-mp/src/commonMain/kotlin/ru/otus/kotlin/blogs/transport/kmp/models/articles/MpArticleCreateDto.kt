package ru.otus.kotlin.blogs.transport.kmp.models.articles

import kotlinx.serialization.Serializable
import ru.otus.kotlin.blogs.transport.kmp.models.common.IMpAricleCreateDto

@Serializable
data class MpArticleCreateDto(
    override val title: String? = null,
    override val text: String? = null,
    override val createAt: String? = null,
    override val categoryId: String? = null,
    override val tagIds: Set<String>? = null,
    override val icon: String? = null
): IMpAricleCreateDto
