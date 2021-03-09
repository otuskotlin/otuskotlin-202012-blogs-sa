package ru.otus.kotlin.blogs.common.models

data class MpArticleModel(
    override val id: IMpArticleIdModel = MpArticleIdModel.NONE,
    override val title: String = "",
    override val text: String = "",
    override val createAt: String = "",
    override val icon: String = "",
    override val categoryId: String = "",
    override val tagIds: Set<String> = mutableSetOf()
): IMpArticleModel {
    companion object {
        val NONE = MpArticleModel()
    }
}
