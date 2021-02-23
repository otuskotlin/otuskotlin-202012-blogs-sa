package ru.otus.kotlin.blogs.common.models

inline class MpArticleIdModel(
    override val id: String
) : IMpArticleIdModel {
    companion object {
        val NONE = MpArticleIdModel("")
    }
}