package ru.otus.kotlin.blogs.common.models

data class MpCategoryModel(
    override val id: IMpCategoryIdModel = MPCategoryIdModel.NONE,
    override val icon: String = "",
    override val title: String = "",
    override val description: String = ""
): IMpCategoryModel {
    companion object {
        val NONE = MpCategoryModel()
    }
}
