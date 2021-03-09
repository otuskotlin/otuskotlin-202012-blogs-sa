package ru.otus.kotlin.blogs.transport.kmp.models.common

interface IMpTagDto : IMpTagUpdateDto {
    val permissions: Set<MpPermission>?
}