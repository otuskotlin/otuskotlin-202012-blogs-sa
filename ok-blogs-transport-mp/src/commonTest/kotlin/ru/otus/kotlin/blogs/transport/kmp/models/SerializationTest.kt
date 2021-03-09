package ru.otus.kotlin.blogs.transport.kmp.models

import kotlinx.serialization.json.Json
import ru.otus.kotlin.blogs.transport.kmp.models.articles.MpArticleCreateDto
import ru.otus.kotlin.blogs.transport.kmp.models.articles.MpArticleUpdateDto
import ru.otus.kotlin.blogs.transport.kmp.models.articles.MpRequestArticleCreate
import ru.otus.kotlin.blogs.transport.kmp.models.articles.MpRequestArticleUpdate
import ru.otus.kotlin.blogs.transport.kmp.models.categories.MpCategoryCreateDto
import ru.otus.kotlin.blogs.transport.kmp.models.categories.MpCategoryUpdateDto
import ru.otus.kotlin.blogs.transport.kmp.models.categories.MpRequestCategoryCreate
import ru.otus.kotlin.blogs.transport.kmp.models.categories.MpRequestCategoryUpdate
import ru.otus.kotlin.blogs.transport.kmp.models.tags.MpRequestTagCreate
import ru.otus.kotlin.blogs.transport.kmp.models.tags.MpRequestTagUpdate
import ru.otus.kotlin.blogs.transport.kmp.models.tags.MpTagCreateDto
import ru.otus.kotlin.blogs.transport.kmp.models.tags.MpTagUpdateDto
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SerializationTest {

    @Test
    fun serializationMpRequestArticleCreateTest() {
        val json = Json {
            prettyPrint = true
        }

        val dto = MpRequestArticleCreate(
            requestId = "create-id",
            startTime = "2021-02-28T12:00:00",
            createData = MpArticleCreateDto(
                title = "title-1",
                text = "some text",
                createAt = "2021-02-27T12:00:00",
                categoryId = "category-1",
                tagIds = setOf("id-1"),
                icon = "icon1"
            )
        )

        val serializedString = json.encodeToString(MpRequestArticleCreate.serializer(), dto)
        println(serializedString)
        assertTrue { serializedString.contains("requestId") }
        assertTrue { serializedString.contains("startTime") }
        assertTrue { serializedString.contains("title-1") }
        assertTrue { serializedString.contains("categoryId") }
        val deserializedDto = json.decodeFromString(MpRequestArticleCreate.serializer(), serializedString)
        assertEquals("id-1", deserializedDto.createData?.tagIds?.firstOrNull())
    }

    @Test
    fun serializationMpRequestArticleUpdateTest() {
        val json = Json {
            prettyPrint = true
        }

        val dto = MpRequestArticleUpdate(
            requestId = "update-id",
            startTime = "2021-02-28T12:00:00",
            updateData = MpArticleUpdateDto(
                id = "article-id",
                title = "title-1",
                text = "some text",
                createAt = "2021-02-27T12:00:00",
                categoryId = "category-1",
                tagIds = setOf("id-1"),
                icon = "icon1"
            )
        )

        val serializedString = json.encodeToString(MpRequestArticleUpdate.serializer(), dto)
        println(serializedString)
        assertTrue { serializedString.contains("requestId") }
        assertTrue { serializedString.contains("startTime") }
        assertTrue { serializedString.contains("title-1") }
        assertTrue { serializedString.contains("categoryId") }
        val deserializedDto = json.decodeFromString(MpRequestArticleUpdate.serializer(), serializedString)
        assertEquals("id-1", deserializedDto.updateData?.tagIds?.firstOrNull())
    }

    @Test
    fun serializationMpRequestCategoryCreateTest() {
        val json = Json {
            prettyPrint = true
        }

        val dto = MpRequestCategoryCreate(
            requestId = "create-id",
            startTime = "2021-02-28T12:00:00",
            createData = MpCategoryCreateDto(
                title = "title-2",
                description = "some description",
                icon = "icon2"
            )
        )
        val serializedString = json.encodeToString(MpRequestCategoryCreate.serializer(), dto)
        println(serializedString)
        assertTrue { serializedString.contains("requestId") }
        assertTrue { serializedString.contains("startTime") }
        assertTrue { serializedString.contains("title-2") }
        val deserializedDto = json.decodeFromString(MpRequestCategoryCreate.serializer(), serializedString)
        assertEquals("icon2", deserializedDto.createData?.icon)
    }

    @Test
    fun serializationMpRequestCategoryUpdateTest() {
        val json = Json {
            prettyPrint = true
        }

        val dto = MpRequestCategoryUpdate(
            requestId = "update-id",
            startTime = "2021-02-28T12:00:00",
            updateData = MpCategoryUpdateDto(
                id = "id-2",
                title = "title-2",
                description = "some description",
                icon = "icon2"
            )
        )
        val serializedString = json.encodeToString(MpRequestCategoryUpdate.serializer(), dto)
        println(serializedString)
        assertTrue { serializedString.contains("requestId") }
        assertTrue { serializedString.contains("startTime") }
        assertTrue { serializedString.contains("title-2") }
        val deserializedDto = json.decodeFromString(MpRequestCategoryUpdate.serializer(), serializedString)
        assertEquals("icon2", deserializedDto.updateData?.icon)
    }

    @Test
    fun serializationMpRequestTagCreateTest() {
        val json = Json {
            prettyPrint = true
        }

        val dto = MpRequestTagCreate(
            requestId = "create-id",
            startTime = "2021-02-28T12:00:00",
            createData = MpTagCreateDto(
                name = "tag-1"
            )
        )
        val serializedString = json.encodeToString(MpRequestTagCreate.serializer(), dto)
        println(serializedString)
        assertTrue { serializedString.contains("requestId") }
        assertTrue { serializedString.contains("startTime") }
        assertTrue { serializedString.contains("tag-1") }
        val deserializedDto = json.decodeFromString(MpRequestTagCreate.serializer(), serializedString)
        assertEquals("tag-1", deserializedDto.createData?.name)
    }

    @Test
    fun serializationMpRequestTagUpdateTest() {
        val json = Json {
            prettyPrint = true
        }

        val dto = MpRequestTagUpdate(
            requestId = "update-id",
            startTime = "2021-02-28T12:00:00",
            updateData = MpTagUpdateDto(
                id = "id-1",
                name = "tag-2"
            )
        )
        val serializedString = json.encodeToString(MpRequestTagUpdate.serializer(), dto)
        println(serializedString)
        assertTrue { serializedString.contains("requestId") }
        assertTrue { serializedString.contains("startTime") }
        assertTrue { serializedString.contains("tag-2") }
        val deserializedDto = json.decodeFromString(MpRequestTagUpdate.serializer(), serializedString)
        assertEquals("tag-2", deserializedDto.updateData?.name)
    }
}