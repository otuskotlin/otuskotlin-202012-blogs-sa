package ru.otus

import io.ktor.http.*
import io.ktor.server.testing.*
import ru.otus.config.jsonConfig
import ru.otus.kotlin.blogs.transport.kmp.models.articles.MpRequestArticleRead
import ru.otus.kotlin.blogs.transport.kmp.models.articles.MpResponseArticleRead
import ru.otus.kotlin.blogs.transport.kmp.models.common.MpMessage
import ru.otus.kotlin.blogs.transport.kmp.models.common.ResponseStatusDto
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class MpArticleTest {

    @Test
    fun articleReadTest(){
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Post, "/article/read") {
                val body = MpRequestArticleRead(
                    requestId = "request-1",
                    articleId = "article-1",
                )
                val format = jsonConfig
                val bodyString = format.encodeToString(MpMessage.serializer(), body)
                setBody(bodyString)
                addHeader("Content-Type", "application/json")
            }.apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals(ContentType.Application.Json.withCharset(Charsets.UTF_8), response.contentType())
                val jsonString = response.content ?: fail("Null response json")
                println(jsonString)

                val response = (jsonConfig.decodeFromString(MpMessage.serializer(), jsonString) as? MpResponseArticleRead)
                    ?: fail("Incorrect response format")

                assertEquals(ResponseStatusDto.SUCCESS, response.status)
                assertEquals("request-1", response.onRequest)
                assertEquals("статья 1", response.article?.title)
            }
        }
    }


}