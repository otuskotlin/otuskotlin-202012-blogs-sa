package ru.otus.kotlin.blogs.common.models

interface IMpArticleModel {
    val id: IMpArticleIdModel
    val title: String
    val text: String
    val createAt: String
    val icon: String
    val categoryId: String
    val tagId: String
}