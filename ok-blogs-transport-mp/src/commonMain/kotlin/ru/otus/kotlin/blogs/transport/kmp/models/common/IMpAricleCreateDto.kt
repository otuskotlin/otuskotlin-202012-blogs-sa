package ru.otus.kotlin.blogs.transport.kmp.models.common

interface IMpAricleCreateDto {
    val title: String?
    val text: String?
    val createAt: String?
    val categoryId: String?
    val tagIds: Set<String>?
    val icon: String?
}