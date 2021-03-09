package ru.otus.kotlin.blogs.transport.kmp.models.common

interface IMpCategoryDto: IMpCategoryUpdateDto {
    val permissions: Set<MpPermission>?
}