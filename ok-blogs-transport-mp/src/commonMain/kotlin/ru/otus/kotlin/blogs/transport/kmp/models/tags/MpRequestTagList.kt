package ru.otus.kotlin.blogs.transport.kmp.models.tags

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.otus.kotlin.blogs.transport.kmp.models.common.IMpDebug
import ru.otus.kotlin.blogs.transport.kmp.models.common.IMpRequest
import ru.otus.kotlin.blogs.transport.kmp.models.common.MpMessage
import ru.otus.kotlin.blogs.transport.kmp.models.common.MpWorkModeDto

@Serializable
@SerialName("MpRequestTagList")
data class MpRequestTagList(
    override val requestId: String? = null,
    override val onResponse: String? = null,
    override val startTime: String? = null,
    override val debug: IMpDebug? = null,
    val filter: MpTagFilterDto? = null
    ) : IMpRequest, MpMessage() {

    @Serializable
    data class Debug(
        override val mode: MpWorkModeDto?
    ) : IMpDebug
}
