package ru.otus.kotlin.blogs.transport.kmp.models.categories

import kotlinx.serialization.Serializable
import ru.otus.kotlin.blogs.transport.kmp.models.common.IMpCategoryUpdateDto

@Serializable
data class MpCategoryUpdateDto(
    override val id: String? = null,
    override val title: String? = null,
    override val description: String? = null,
    override val icon: String? = null
): IMpCategoryUpdateDto
