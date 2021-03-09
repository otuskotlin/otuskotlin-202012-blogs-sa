package ru.otus.kotlin.blogs.transport.kmp.models.articles

import kotlinx.serialization.Serializable
import ru.otus.kotlin.blogs.transport.kmp.models.common.IMpArticleUpdateDto

@Serializable
data class MpArticleUpdateDto(
    override val id: String?,
    override val title: String?,
    override val text: String?,
    override val createAt: String?,
    override val categoryId: String?,
    override val tagIds: Set<String>?,
    override val icon: String?
): IMpArticleUpdateDto
