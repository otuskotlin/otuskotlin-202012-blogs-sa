package ru.otus.kotlin.blogs.common.models

inline class MPCategoryIdModel(
    override val id: String
    ): IMpCategoryIdModel {
        companion object {
            val NONE = MPCategoryIdModel("")
        }
}