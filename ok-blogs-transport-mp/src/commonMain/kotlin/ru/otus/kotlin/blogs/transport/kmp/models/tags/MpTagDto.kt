package ru.otus.kotlin.blogs.transport.kmp.models.tags

import kotlinx.serialization.Serializable
import ru.otus.kotlin.blogs.transport.kmp.models.common.IMpTagDto
import ru.otus.kotlin.blogs.transport.kmp.models.common.MpPermission

@Serializable
data class MpTagDto(
    override val id: String? = null,
    override val name: String? = null,
    override val permissions: Set<MpPermission>? = null
): IMpTagDto
