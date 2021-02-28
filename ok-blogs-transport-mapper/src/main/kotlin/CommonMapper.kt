import ru.otus.kotlin.blogs.common.context.MpBeContext
import ru.otus.kotlin.blogs.transport.kmp.models.articles.MpRequestArticleCreate
import ru.otus.kotlin.blogs.transport.kmp.models.articles.MpRequestArticleDelete
import ru.otus.kotlin.blogs.transport.kmp.models.articles.MpRequestArticleRead
import ru.otus.kotlin.blogs.transport.kmp.models.articles.MpRequestArticleUpdate
import ru.otus.kotlin.blogs.transport.kmp.models.categories.MpRequestCategoryCreate
import ru.otus.kotlin.blogs.transport.kmp.models.categories.MpRequestCategoryDelete
import ru.otus.kotlin.blogs.transport.kmp.models.categories.MpRequestCategoryRead
import ru.otus.kotlin.blogs.transport.kmp.models.categories.MpRequestCategoryUpdate
import ru.otus.kotlin.blogs.transport.kmp.models.common.IMpRequest
import ru.otus.kotlin.blogs.transport.kmp.models.tags.MpRequestTagCreate
import ru.otus.kotlin.blogs.transport.kmp.models.tags.MpRequestTagDelete
import ru.otus.kotlin.blogs.transport.kmp.models.tags.MpRequestTagRead
import ru.otus.kotlin.blogs.transport.kmp.models.tags.MpRequestTagUpdate

fun MpBeContext.setQuery(request: IMpRequest) {
    when(request) {
        is MpRequestArticleRead -> this.setArticleReadQuery(request)
        is MpRequestArticleCreate -> this.setArticleCreateQuery(request)
        is MpRequestArticleUpdate -> this.setArticleUpdateQuery(request)
        is MpRequestArticleDelete -> this.setArticleDeleteQuery(request)

        is MpRequestCategoryRead -> this.setCategoryReadQuery(request)
        is MpRequestCategoryCreate -> this.setCategoryCreateQuery(request)
        is MpRequestCategoryUpdate -> this.setCategoryUpdateQuery(request)
        is MpRequestCategoryDelete -> this.setCategoryDeleteQuery(request)

        is MpRequestTagRead -> this.setTagReadQuery(request)
        is MpRequestTagCreate -> this.setTagCreateQuery(request)
        is MpRequestTagUpdate -> this.setTagUpdateQuery(request)
        is MpRequestTagDelete -> this.setTagDeleteQuery(request)

    }
}