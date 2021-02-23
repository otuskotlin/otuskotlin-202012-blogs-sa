package ru.otus.kotlin.blogs.transport.kmp.models.articles

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.otus.kotlin.blogs.transport.kmp.models.common.IMpDebug
import ru.otus.kotlin.blogs.transport.kmp.models.common.IMpRequest
import ru.otus.kotlin.blogs.transport.kmp.models.common.MpMessage

@Serializable
@SerialName("MpRequestArticleCreate")
data class MpRequestArticleCreate(
    override val requestId: String? = null,
    override val onResponse: String? = null,
    override val startTime: String? = null,
    override val debug: IMpDebug? = null,
    val createData: MpArticleCreateDto? = null
): IMpRequest, MpMessage() {
}