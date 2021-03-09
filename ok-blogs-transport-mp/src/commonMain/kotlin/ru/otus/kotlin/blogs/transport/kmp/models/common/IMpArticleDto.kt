package ru.otus.kotlin.blogs.transport.kmp.models.common

interface IMpArticleDto : IMpArticleUpdateDto{
    val permissions: Set<MpPermission>?
}