package ru.otus.config

import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import ru.otus.kotlin.blogs.transport.kmp.models.articles.*
import ru.otus.kotlin.blogs.transport.kmp.models.categories.*
import ru.otus.kotlin.blogs.transport.kmp.models.common.MpMessage
import ru.otus.kotlin.blogs.transport.kmp.models.tags.*

val jsonConfig: Json by lazy {
    Json {
        prettyPrint = true
        serializersModule = SerializersModule {
            polymorphic(MpMessage::class) {
                subclass(MpRequestArticleCreate::class)
                subclass(MpRequestArticleRead::class)
                subclass(MpRequestArticleUpdate::class)
                subclass(MpRequestArticleDelete::class)
                subclass(MpRequestArticleList::class)
                subclass(MpResponseArticleCreate::class)
                subclass(MpResponseArticleRead::class)
                subclass(MpResponseArticleUpdate::class)
                subclass(MpResponseArticleDelete::class)
                subclass(MpResponseArticleList::class)
                subclass(MpRequestCategoryCreate::class)
                subclass(MpRequestCategoryRead::class)
                subclass(MpRequestCategoryUpdate::class)
                subclass(MpRequestCategoryDelete::class)
                subclass(MpRequestCategoryList::class)
                subclass(MpResponseCategoryCreate::class)
                subclass(MpResponseCategoryRead::class)
                subclass(MpResponseCategoryUpdate::class)
                subclass(MpResponseCategoryDelete::class)
                subclass(MpResponseCategoryList::class)
                subclass(MpRequestTagCreate::class)
                subclass(MpRequestTagRead::class)
                subclass(MpRequestTagUpdate::class)
                subclass(MpRequestTagDelete::class)
                subclass(MpRequestTagList::class)
                subclass(MpResponseTagCreate::class)
                subclass(MpResponseTagRead::class)
                subclass(MpResponseTagUpdate::class)
                subclass(MpResponseTagDelete::class)
                subclass(MpResponseTagList::class)
            }
        }
        classDiscriminator = "type"
    }
}