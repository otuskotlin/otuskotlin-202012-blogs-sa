package ru.otus.controllers

import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.util.pipeline.*
import org.slf4j.LoggerFactory
import ru.otus.kotlin.blogs.common.context.MpBeContext
import ru.otus.kotlin.blogs.transport.kmp.models.common.MpMessage
import ru.otus.kotlin.blogs.transport.kmp.models.common.ResponseStatusDto
import ru.otus.kotlin.blogs.transport.kmp.models.tags.*
import ru.otus.service.TagService
import setQuery
import java.time.Instant
import java.util.*

class TagController {
    private val log = LoggerFactory.getLogger(this::class.java)!!
    private val tagService = TagService()

    suspend fun read(pipeLine: PipelineContext<Unit, ApplicationCall>) {
        try {
            val request = pipeLine.call.receive<MpMessage>() as MpRequestTagRead
            val context = MpBeContext()
            context.setQuery(request)
            val response: MpMessage = MpResponseTagRead(
                responseId = UUID.randomUUID().toString(),
                onRequest = request.requestId,
                endTime = Instant.now().toString(),
                status = ResponseStatusDto.SUCCESS,
                tag = tagService.read(context.requestTagId.id)
            )
            pipeLine.call.respond(response)
        } catch (e: Throwable) {
            log.error("Read chain error", e)
        }
    }

    suspend fun create(pipeLine: PipelineContext<Unit, ApplicationCall>) {
        try {
            val request = pipeLine.call.receive<MpMessage>() as MpRequestTagCreate
            val context = MpBeContext()
            context.setQuery(request)
            val response: MpMessage = MpResponseTagCreate(
                responseId = UUID.randomUUID().toString(),
                onRequest = request.requestId,
                endTime = Instant.now().toString(),
                status = ResponseStatusDto.SUCCESS,
                tag = tagService.create(context.requestTag)
            )

            pipeLine.call.respond(response)
        } catch (e: Throwable) {
            log.error("Read chain error", e)
        }
    }

    suspend fun update(pipeLine: PipelineContext<Unit, ApplicationCall>) {
        try {
            val request = pipeLine.call.receive<MpMessage>() as MpRequestTagUpdate
            val context = MpBeContext()
            context.setQuery(request)
            val response: MpMessage = MpResponseTagUpdate(
                responseId = UUID.randomUUID().toString(),
                onRequest = request.requestId,
                endTime = Instant.now().toString(),
                status = ResponseStatusDto.SUCCESS,
                tag = tagService.update(context.requestTag)
            )

            pipeLine.call.respond(response)
        } catch (e: Throwable) {
            log.error("Read chain error", e)
        }
    }

    suspend fun delete(pipeLine: PipelineContext<Unit, ApplicationCall>) {
        try {
            val request = pipeLine.call.receive<MpMessage>() as MpRequestTagDelete
            val context = MpBeContext()
            context.setQuery(request)

            val response: MpMessage = MpResponseTagDelete(
                responseId = UUID.randomUUID().toString(),
                onRequest = request.requestId,
                endTime = Instant.now().toString(),
                status = ResponseStatusDto.SUCCESS,
                deleted = true,
                tagId = tagService.delete(context.requestArticleId.id)
            )
            pipeLine.call.respond(response)
        } catch (e: Throwable) {
            log.error("Read chain error", e)
        }
    }
}