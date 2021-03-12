package ru.otus.controllers

import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.util.pipeline.*
import org.slf4j.LoggerFactory
import ru.otus.kotlin.blogs.common.context.MpBeContext
import ru.otus.kotlin.blogs.transport.kmp.models.categories.*
import ru.otus.kotlin.blogs.transport.kmp.models.common.MpMessage
import ru.otus.kotlin.blogs.transport.kmp.models.common.ResponseStatusDto
import ru.otus.service.CategoryService
import setQuery
import java.time.Instant
import java.util.*

class CategoryController {
    private val log = LoggerFactory.getLogger(this::class.java)!!
    private val categoryService = CategoryService()

    suspend fun read(pipeLine: PipelineContext<Unit, ApplicationCall>) {
        try {
            val request = pipeLine.call.receive<MpMessage>() as MpRequestCategoryRead
            val context = MpBeContext()
            context.setQuery(request)
            val response: MpMessage = MpResponseCategoryRead(
                responseId = UUID.randomUUID().toString(),
                onRequest = request.requestId,
                endTime = Instant.now().toString(),
                status = ResponseStatusDto.SUCCESS,
                category = categoryService.read(context.requestCategoryId.id)
            )
            pipeLine.call.respond(response)
        } catch (e: Throwable) {
            log.error("Read chain error", e)
        }
    }

    suspend fun create(pipeLine: PipelineContext<Unit, ApplicationCall>) {
        try {
            val request = pipeLine.call.receive<MpMessage>() as MpRequestCategoryCreate
            val context = MpBeContext()
            context.setQuery(request)
            val response: MpMessage = MpResponseCategoryCreate(
                responseId = UUID.randomUUID().toString(),
                onRequest = request.requestId,
                endTime = Instant.now().toString(),
                status = ResponseStatusDto.SUCCESS,
                category = categoryService.create(context.requestCategory)
            )

            pipeLine.call.respond(response)
        } catch (e: Throwable) {
            log.error("Read chain error", e)
        }
    }

    suspend fun update(pipeLine: PipelineContext<Unit, ApplicationCall>) {
        try {
            val request = pipeLine.call.receive<MpMessage>() as MpRequestCategoryUpdate
            val context = MpBeContext()
            context.setQuery(request)
            val response: MpMessage = MpResponseCategoryUpdate(
                responseId = UUID.randomUUID().toString(),
                onRequest = request.requestId,
                endTime = Instant.now().toString(),
                status = ResponseStatusDto.SUCCESS,
                category = categoryService.update(context.requestCategory)
            )

            pipeLine.call.respond(response)
        } catch (e: Throwable) {
            log.error("Read chain error", e)
        }
    }

    suspend fun delete(pipeLine: PipelineContext<Unit, ApplicationCall>) {
        try {
            val request = pipeLine.call.receive<MpMessage>() as MpRequestCategoryDelete
            val context = MpBeContext()
            context.setQuery(request)

            val response: MpMessage = MpResponseCategoryDelete(
                responseId = UUID.randomUUID().toString(),
                onRequest = request.requestId,
                endTime = Instant.now().toString(),
                status = ResponseStatusDto.SUCCESS,
                deleted = true,
                categoryId = categoryService.delete(context.requestCategoryId.id)
            )
            pipeLine.call.respond(response)
        } catch (e: Throwable) {
            log.error("Read chain error", e)
        }
    }
}