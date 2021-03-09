import ru.otus.kotlin.blogs.common.context.MpBeContext
import ru.otus.kotlin.blogs.common.models.MPCategoryIdModel
import ru.otus.kotlin.blogs.common.models.MpCategoryModel
import ru.otus.kotlin.blogs.transport.kmp.models.categories.MpRequestCategoryCreate
import ru.otus.kotlin.blogs.transport.kmp.models.categories.MpRequestCategoryDelete
import ru.otus.kotlin.blogs.transport.kmp.models.categories.MpRequestCategoryRead
import ru.otus.kotlin.blogs.transport.kmp.models.categories.MpRequestCategoryUpdate

fun MpBeContext.setCategoryReadQuery(request: MpRequestCategoryRead) {
    requestCategoryId = request.categoryId?.let { MPCategoryIdModel(it) } ?: MPCategoryIdModel.NONE
}

fun MpBeContext.setCategoryCreateQuery(request: MpRequestCategoryCreate) {
    requestCategory = MpCategoryModel(
        title = request.createData?.title ?: "",
        icon = request.createData?.icon ?: "",
        description = request.createData?.description ?: ""
    )
}

fun MpBeContext.setCategoryUpdateQuery(request: MpRequestCategoryUpdate) {
    requestCategory = MpCategoryModel(
        id = request.updateData?.id?.let { MPCategoryIdModel(it) } ?: MPCategoryIdModel.NONE,
        title = request.updateData?.title ?: "",
        icon = request.updateData?.icon ?: "",
        description = request.updateData?.description ?: ""
    )
}

fun MpBeContext.setCategoryDeleteQuery(request: MpRequestCategoryDelete) {
    requestCategoryId = request.categoryId?.let { MPCategoryIdModel(it) } ?: MPCategoryIdModel.NONE
}