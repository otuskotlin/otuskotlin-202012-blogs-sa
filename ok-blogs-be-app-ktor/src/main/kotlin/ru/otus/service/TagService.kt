package ru.otus.service

import ru.otus.kotlin.blogs.common.models.MpTagModel
import ru.otus.kotlin.blogs.transport.kmp.models.tags.MpTagDto
import java.util.*

class TagService {
    fun read(id : String) : MpTagDto {
        return MpTagDto(
            id = id,
            name = "тэг 1"
        )
    }

    fun create(createDate: MpTagModel) : MpTagDto {
        return MpTagDto(
            id = UUID.randomUUID().toString(),
            name = createDate.name
            )
    }

    fun update(updateDate: MpTagModel) : MpTagDto {
        return MpTagDto(
            id = updateDate.id.id,
            name = updateDate.name
        )
    }

    fun delete(id : String) : String {
        return id
    }
}