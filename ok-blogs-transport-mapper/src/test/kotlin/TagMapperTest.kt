import org.junit.Test
import ru.otus.kotlin.blogs.common.context.MpBeContext
import ru.otus.kotlin.blogs.transport.kmp.models.tags.*
import kotlin.test.assertEquals

class TagMapperTest {
    @Test
    fun requestTagCreateMappingTest() {
        val request = MpRequestTagCreate(
            createData = MpTagCreateDto(
                name = "name1"
            )
        )

        val context = MpBeContext()

        context.setQuery(request)

        assertEquals("name1", context.requestTag.name)
    }

    @Test
    fun requestTagUpdateMappingTest() {
        val request = MpRequestTagUpdate(
            updateData = MpTagUpdateDto(
                id = "id-1",
                name = "name1"
            )
        )

        val context = MpBeContext()

        context.setQuery(request)

        assertEquals("id-1", context.requestTag.id.id)
        assertEquals("name1", context.requestTag.name)
    }

    @Test
    fun requestTagReadMappingTest() {
        val request = MpRequestTagRead(
            requestId = "id-1"
        )
        val context = MpBeContext()

        context.setQuery(request)

        assertEquals("id-1", context.requestTagId)

    }

    @Test
    fun requestTagDeleteMappingTest() {
        val request = MpRequestTagDelete(
            requestId = "id-1"
        )
        val context = MpBeContext()

        context.setQuery(request)

        assertEquals("id-1", context.requestTagId)

    }
}