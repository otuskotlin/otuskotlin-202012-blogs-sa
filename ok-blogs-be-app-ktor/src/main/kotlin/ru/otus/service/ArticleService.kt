package ru.otus.service

import ru.otus.kotlin.blogs.common.models.MpArticleModel
import ru.otus.kotlin.blogs.transport.kmp.models.articles.MpArticleDto
import java.time.Instant
import java.util.*

class ArticleService {

    fun read(id : String) : MpArticleDto {
        return MpArticleDto(
            id = id,
            title = "статья 1",
            text = "Верьте аль не верьте, а жил на белом свете Федот-стрелец, удалой молодец...",
            createAt = "2007-12-03T10:15:30.00Z",
            categoryId = "q1",
            tagIds = setOf("t1", "t2"),
            icon = "icon1",
        )
    }

    fun create(createDate: MpArticleModel) : MpArticleDto {
        return MpArticleDto(
            id = UUID.randomUUID().toString(),
            title = createDate.title,
            text = createDate.text,
            createAt = Instant.now().toString(),
            categoryId = createDate.categoryId,
            tagIds = createDate.tagIds,
            icon = createDate.icon
        )
    }

    fun update(updateDate: MpArticleModel) : MpArticleDto {
        return MpArticleDto(
            id = updateDate.id.id,
            title = updateDate.title,
            text = updateDate.text,
            createAt = Instant.now().toString(),
            categoryId = updateDate.categoryId,
            tagIds = updateDate.tagIds,
            icon = updateDate.icon
        )
    }

    fun delete(id : String) : String {
        return id
    }
}