package ru.otus.controllers

import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.util.pipeline.*
import org.slf4j.LoggerFactory
import ru.otus.kotlin.blogs.common.context.MpBeContext
import ru.otus.kotlin.blogs.transport.kmp.models.articles.*
import ru.otus.kotlin.blogs.transport.kmp.models.common.MpMessage
import ru.otus.kotlin.blogs.transport.kmp.models.common.ResponseStatusDto
import ru.otus.service.ArticleService
import setQuery
import java.time.Instant
import java.util.*

class ArticleController {

    private val log = LoggerFactory.getLogger(this::class.java)!!
    private val articleService = ArticleService()

    suspend fun read(pipeLine: PipelineContext<Unit, ApplicationCall>) {
        try {
            val request = pipeLine.call.receive<MpMessage>() as MpRequestArticleRead
            val context = MpBeContext()
            context.setQuery(request)
            val response: MpMessage = MpResponseArticleRead(
                responseId = UUID.randomUUID().toString(),
                onRequest = request.requestId,
                endTime = Instant.now().toString(),
                status = ResponseStatusDto.SUCCESS,
                article = articleService.read(context.requestArticleId.id)
            )
            pipeLine.call.respond(response)
        } catch (e: Throwable) {
            log.error("Read chain error", e)
        }
    }

    suspend fun create(pipeLine: PipelineContext<Unit, ApplicationCall>) {
        try {
            val request = pipeLine.call.receive<MpMessage>() as MpRequestArticleCreate
            val context = MpBeContext()
            context.setQuery(request)
            val response: MpMessage = MpResponseArticleCreate(
                responseId = UUID.randomUUID().toString(),
                onRequest = request.requestId,
                endTime = Instant.now().toString(),
                status = ResponseStatusDto.SUCCESS,
                article = articleService.create(context.requestArticle)
            )

            pipeLine.call.respond(response)
        } catch (e: Throwable) {
            log.error("Read chain error", e)
        }
    }

    suspend fun update(pipeLine: PipelineContext<Unit, ApplicationCall>) {
        try {
            val request = pipeLine.call.receive<MpMessage>() as MpRequestArticleUpdate
            val context = MpBeContext()
            context.setQuery(request)
            val response: MpMessage = MpResponseArticleUpdate(
                responseId = UUID.randomUUID().toString(),
                onRequest = request.requestId,
                endTime = Instant.now().toString(),
                status = ResponseStatusDto.SUCCESS,
                article = articleService.update(context.requestArticle)
            )

            pipeLine.call.respond(response)
        } catch (e: Throwable) {
            log.error("Read chain error", e)
        }
    }

    suspend fun delete(pipeLine: PipelineContext<Unit, ApplicationCall>) {
        try {
            val request = pipeLine.call.receive<MpMessage>() as MpRequestArticleDelete
            val context = MpBeContext()
            context.setQuery(request)

            val response: MpMessage = MpResponseArticleDelete(
                responseId = UUID.randomUUID().toString(),
                onRequest = request.requestId,
                endTime = Instant.now().toString(),
                status = ResponseStatusDto.SUCCESS,
                deleted = true,
                articleId = articleService.delete(context.requestArticleId.id)
            )
            pipeLine.call.respond(response)
        } catch (e: Throwable) {
            log.error("Read chain error", e)
        }
    }
}