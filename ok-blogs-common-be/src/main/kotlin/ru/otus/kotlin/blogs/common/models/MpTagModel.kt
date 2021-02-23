package ru.otus.kotlin.blogs.common.models

data class MpTagModel(
    override val id: IMpTagIdModel = MpTagIdModel.NONE,
    override val name: String = ""
): IMpTagModel {
    companion object {
        val NONE = MpTagModel()
    }
}
