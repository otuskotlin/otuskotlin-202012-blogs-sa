package ru.otus.kotlin.blogs.transport.kmp.models.articles

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.otus.kotlin.blogs.transport.kmp.models.common.IMpDebug
import ru.otus.kotlin.blogs.transport.kmp.models.common.IMpRequest
import ru.otus.kotlin.blogs.transport.kmp.models.common.MpMessage
import ru.otus.kotlin.blogs.transport.kmp.models.common.MpWorkModeDto

@Serializable
@SerialName("MpRequestArticleDelete")
data class MpRequestArticleDelete(
    override val requestId: String? = null,
    override val onResponse: String? = null,
    override val startTime: String? = null,
    override val debug: IMpDebug? = null,
    val articleId: String? = null,
    val deleted: Boolean? = null
): MpMessage(), IMpRequest {

    @Serializable
    data class Debug(
        override val mode: MpWorkModeDto?
    ) : IMpDebug
}
