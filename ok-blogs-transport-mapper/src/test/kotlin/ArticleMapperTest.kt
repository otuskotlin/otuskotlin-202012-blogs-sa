import org.junit.Test
import ru.otus.kotlin.blogs.common.context.MpBeContext
import ru.otus.kotlin.blogs.transport.kmp.models.articles.*
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ArticleMapperTest {
    @Test
    fun requestArticleCreateMappingTest() {
        val request = MpRequestArticleCreate(
            createData = MpArticleCreateDto(
                title = "article-1",
                text = "some text",
                createAt = "2021-02-28T12:00:00",
                categoryId = "category-1",
                icon = "icon1",
                tagIds = setOf("tag1", "tag2")
            )
        )

        val context = MpBeContext()

        context.setQuery(request)

        assertEquals("article-1", context.requestArticle.title)
        assertEquals("some text", context.requestArticle.text)
        assertEquals("2021-02-28T12:00:00", context.requestArticle.createAt)
        assertEquals("category-1", context.requestArticle.categoryId)
        assertEquals("icon1", context.requestArticle.icon)
        assertTrue { context.requestArticle.tagIds.contains("tag1") }
    }

    @Test
    fun requestArticleUpdateMappingTest() {
        val request = MpRequestArticleUpdate(
            updateData = MpArticleUpdateDto(
                id = "id-1",
                title = "article-1",
                text = "some text",
                createAt = "2021-02-28T12:00:00",
                categoryId = "category-1",
                icon = "icon1",
                tagIds = setOf("tag1", "tag2")
            )
        )

        val context = MpBeContext()

        context.setQuery(request)

        assertEquals("id-1", context.requestArticle.id.id)
        assertEquals("article-1", context.requestArticle.title)
        assertEquals("some text", context.requestArticle.text)
        assertEquals("2021-02-28T12:00:00", context.requestArticle.createAt)
        assertEquals("category-1", context.requestArticle.categoryId)
        assertEquals("icon1", context.requestArticle.icon)
        assertTrue { context.requestArticle.tagIds.contains("tag2") }
    }

    @Test
    fun requestArticleReadMappingTest() {
        val request = MpRequestArticleRead(
            articleId = "id-1"
        )
        val context = MpBeContext()

        context.setQuery(request)

        assertEquals("id-1", context.requestArticleId)
    }

    @Test
    fun requestArticleDeleteMappingTest() {
        val request = MpRequestArticleDelete(
            articleId = "id-1"
        )
        val context = MpBeContext()

        context.setQuery(request)

        assertEquals("id-1", context.requestArticleId)
    }
}