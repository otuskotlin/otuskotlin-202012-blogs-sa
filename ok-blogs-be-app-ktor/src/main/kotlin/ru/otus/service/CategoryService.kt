package ru.otus.service

import ru.otus.kotlin.blogs.common.models.MpCategoryModel
import ru.otus.kotlin.blogs.transport.kmp.models.categories.MpCategoryDto
import java.util.*

class CategoryService {
    fun read(id : String) : MpCategoryDto {
        return MpCategoryDto(
            id = id,
            title = "категория 1",
            description = "Описание категории 1",
            icon = "icon1",
        )
    }

    fun create(createDate: MpCategoryModel) : MpCategoryDto {
        return MpCategoryDto(
            id = UUID.randomUUID().toString(),
            title = createDate.title,
            description = createDate.description,
            icon = createDate.icon
        )
    }

    fun update(updateDate: MpCategoryModel) : MpCategoryDto {
        return MpCategoryDto(
            id = updateDate.id.id,
            title = updateDate.title,
            description = updateDate.description,
            icon = updateDate.icon
        )
    }

    fun delete(id : String) : String {
        return id
    }
}