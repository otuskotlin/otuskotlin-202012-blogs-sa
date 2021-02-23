package ru.otus.kotlin.blogs.transport.kmp.models.categories

import kotlinx.serialization.Serializable
import ru.otus.kotlin.blogs.transport.kmp.models.common.IMpCategoryDto
import ru.otus.kotlin.blogs.transport.kmp.models.common.MpPermission

@Serializable
data class MpCategoryDto (
    override val id: String? = null,
    override val icon: String? = null,
    override val title: String? = null,
    override val description: String? = null,
    override val permissions: Set<MpPermission>? = null
): IMpCategoryDto