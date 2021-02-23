package ru.otus.kotlin.blogs.transport.kmp.models.articles

import kotlinx.serialization.Serializable
import ru.otus.kotlin.blogs.transport.kmp.models.common.IMpArticleDto
import ru.otus.kotlin.blogs.transport.kmp.models.common.MpPermission

@Serializable
data class MpArticleDto(
    override val id: String? = null,
    override val title: String? = null,
    override val text: String? = null,
    override val createAt: String? = null,
    override val categoryId: String? = null,
    override val tagIds: Set<String>? = null,
    override val icon: String? = null,
    override val permissions: Set<MpPermission>? = null
): IMpArticleDto
