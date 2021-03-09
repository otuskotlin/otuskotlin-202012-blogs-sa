package ru.otus.kotlin.blogs.common.models

inline class MpTagIdModel(
    override val id: String
): IMpTagIdModel {
    companion object {
        val NONE = MpTagIdModel("")
    }
}