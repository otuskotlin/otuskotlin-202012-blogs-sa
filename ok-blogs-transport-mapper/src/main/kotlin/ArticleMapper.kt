import ru.otus.kotlin.blogs.common.context.MpBeContext
import ru.otus.kotlin.blogs.common.models.MpArticleIdModel
import ru.otus.kotlin.blogs.common.models.MpArticleModel
import ru.otus.kotlin.blogs.transport.kmp.models.articles.MpRequestArticleCreate
import ru.otus.kotlin.blogs.transport.kmp.models.articles.MpRequestArticleDelete
import ru.otus.kotlin.blogs.transport.kmp.models.articles.MpRequestArticleRead
import ru.otus.kotlin.blogs.transport.kmp.models.articles.MpRequestArticleUpdate

fun MpBeContext.setArticleReadQuery(request: MpRequestArticleRead){
    this.requestArticleId = request.articleId?.let { MpArticleIdModel(it) } ?: MpArticleIdModel.NONE
}

fun MpBeContext.setArticleCreateQuery(request: MpRequestArticleCreate) {
    requestArticle = MpArticleModel(
        title = request.createData?.title?: "",
        text = request.createData?.text?: "",
        createAt = request.createData?.createAt?: "",
        icon = request.createData?.categoryId?: "",
        tagIds = request.createData?.tagIds?.toMutableSet()?: mutableSetOf()
    )
}

fun MpBeContext.setArticleUpdateQuery(request: MpRequestArticleUpdate) {
    requestArticle = MpArticleModel(
        id = request.updateData?.id?.let { MpArticleIdModel(it) } ?: MpArticleIdModel.NONE,
        title = request.updateData?.title?: "",
        text = request.updateData?.text?: "",
        createAt = request.updateData?.createAt?: "",
        icon = request.updateData?.categoryId?: "",
        tagIds = request.updateData?.tagIds?.toMutableSet()?: mutableSetOf()
    )
}

fun MpBeContext.setArticleDeleteQuery(request: MpRequestArticleDelete) {
    this.requestArticleId = request.articleId?.let { MpArticleIdModel(it) } ?: MpArticleIdModel.NONE
}