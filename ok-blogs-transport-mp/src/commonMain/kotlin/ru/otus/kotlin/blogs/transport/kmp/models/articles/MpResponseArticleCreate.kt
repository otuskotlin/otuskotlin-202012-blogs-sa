package ru.otus.kotlin.blogs.transport.kmp.models.articles

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.otus.kotlin.blogs.transport.kmp.models.common.*

@Serializable
@SerialName("MpResponseArticleCreate")
data class MpResponseArticleCreate(
    override val responseId: String? = null,
    override val onRequest: String? = null,
    override val endTime: String? = null,
    override val errors: List<ErrorDto>? = null,
    override val status: ResponseStatusDto? = null,
    override val debug: IMpDebug? = null,
    val article: MpArticleCreateDto? = null
): MpMessage(), IMpResponse {

    @Serializable
    data class Debug(
        override val mode: MpWorkModeDto?
    ) : IMpDebug
}