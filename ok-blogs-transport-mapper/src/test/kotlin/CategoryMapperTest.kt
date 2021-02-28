import org.junit.Test
import ru.otus.kotlin.blogs.common.context.MpBeContext
import ru.otus.kotlin.blogs.transport.kmp.models.categories.*
import kotlin.test.assertEquals

class CategoryMapperTest {
    @Test
    fun requestCategoryCreateMappingTest() {
        val request = MpRequestCategoryCreate(
            createData = MpCategoryCreateDto(
                title = "article-1",
                description = "some description",
                icon = "icon1",

                )
        )

        val context = MpBeContext()

        context.setQuery(request)

        assertEquals("article-1", context.requestCategory.title)
        assertEquals("some description", context.requestCategory.description)
        assertEquals("icon1", context.requestCategory.icon)
    }

    @Test
    fun requestCategoryUpdateMappingTest() {
        val request = MpRequestCategoryUpdate(
            updateData = MpCategoryUpdateDto(
                id = "id-1",
                title = "article-1",
                description = "some description",
                icon = "icon1",

                )
        )

        val context = MpBeContext()

        context.setQuery(request)

        assertEquals("id-1", context.requestCategory.id.id)
        assertEquals("article-1", context.requestCategory.title)
        assertEquals("some description", context.requestCategory.description)
        assertEquals("icon1", context.requestCategory.icon)
    }

    @Test
    fun requestCategoryReadMappingTest() {
        val request = MpRequestCategoryRead(
            categoryId = "id-1"
        )
        val context = MpBeContext()
        context.setQuery(request)

        assertEquals("id-1", context.requestCategoryId)
    }

    @Test
    fun requestCategoryDeleteMappingTest() {
        val request = MpRequestCategoryDelete(
            categoryId = "id-1"
        )
        val context = MpBeContext()
        context.setQuery(request)

        assertEquals("id-1", context.requestCategoryId)
    }
}