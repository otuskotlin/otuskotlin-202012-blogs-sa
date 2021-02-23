package ru.otus.kotlin.blogs.common.context

import ru.otus.kotlin.blogs.common.models.*

data class MpBeContext(
    var requestArticleId: MpArticleIdModel = MpArticleIdModel.NONE,
    var requestCategoryId: MPCategoryIdModel = MPCategoryIdModel.NONE,
    var requestTagId: MpTagIdModel = MpTagIdModel.NONE,
    var requestArticle: MpArticleModel = MpArticleModel.NONE,
    var requestCategory: MpCategoryModel = MpCategoryModel.NONE,
    var requestTag: MpTagModel = MpTagModel.NONE,

    var responseArticle: MpArticleModel = MpArticleModel.NONE,
    var responseCategory:MpCategoryModel = MpCategoryModel.NONE,
    var responseTag: MpTagModel = MpTagModel.NONE,
)
