import ru.otus.kotlin.blogs.common.context.MpBeContext
import ru.otus.kotlin.blogs.common.models.MpTagIdModel
import ru.otus.kotlin.blogs.common.models.MpTagModel
import ru.otus.kotlin.blogs.transport.kmp.models.tags.MpRequestTagCreate
import ru.otus.kotlin.blogs.transport.kmp.models.tags.MpRequestTagDelete
import ru.otus.kotlin.blogs.transport.kmp.models.tags.MpRequestTagRead
import ru.otus.kotlin.blogs.transport.kmp.models.tags.MpRequestTagUpdate

fun MpBeContext.setTagReadQuery(request: MpRequestTagRead) {
    requestTagId = request.tagId?.let { MpTagIdModel(it) } ?: MpTagIdModel.NONE
}

fun MpBeContext.setTagCreateQuery(request: MpRequestTagCreate) {
    requestTag = MpTagModel(
        name = request.createData?.name?: ""
    )
}

fun MpBeContext.setTagUpdateQuery(request: MpRequestTagUpdate) {
    requestTag = MpTagModel(
        id = request.updateData?.id?.let { MpTagIdModel(it) } ?: MpTagIdModel.NONE,
        name = request.updateData?.name?: ""
    )
}


fun MpBeContext.setTagDeleteQuery(request: MpRequestTagDelete) {
    requestTagId = request.tagId?.let { MpTagIdModel(it) } ?: MpTagIdModel.NONE
}