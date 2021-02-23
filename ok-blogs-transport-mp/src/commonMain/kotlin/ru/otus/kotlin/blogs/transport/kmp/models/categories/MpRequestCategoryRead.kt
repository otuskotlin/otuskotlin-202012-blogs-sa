package ru.otus.kotlin.blogs.transport.kmp.models.categories

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.otus.kotlin.blogs.transport.kmp.models.common.IMpDebug
import ru.otus.kotlin.blogs.transport.kmp.models.common.IMpRequest
import ru.otus.kotlin.blogs.transport.kmp.models.common.MpMessage
import ru.otus.kotlin.blogs.transport.kmp.models.common.MpWorkModeDto

@Serializable
@SerialName("MpRequestCategoryRead")
data class MpRequestCategoryRead(
    override val requestId: String?,
    override val onResponse: String?,
    override val startTime: String?,
    override val debug: IMpDebug?,
    val categoryId: String?
):IMpRequest, MpMessage() {

    @Serializable
    data class Debug(
        override val mode: MpWorkModeDto?
    ) : IMpDebug
}