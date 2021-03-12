package ru.otus.kotlin.blogs.transport.kmp.models.categories

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.otus.kotlin.blogs.transport.kmp.models.common.*

@Serializable
@SerialName("MpResponseCategoryDelete")
data class MpResponseCategoryDelete(
    override val responseId: String? = null,
    override val onRequest: String? = null,
    override val endTime: String? = null,
    override val errors: List<ErrorDto>? = null,
    override val status: ResponseStatusDto? = null,
    override val debug: IMpDebug? = null,
    val categoryId: String? = null,
    val deleted: Boolean? = null
): IMpResponse, MpMessage(){

    @Serializable
    data class Debug(
        override val mode: MpWorkModeDto?
    ) : IMpDebug
}
