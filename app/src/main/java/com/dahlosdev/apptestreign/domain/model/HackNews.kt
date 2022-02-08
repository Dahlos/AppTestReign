package com.dahlosdev.apptestreign.domain.model

import com.dahlosdev.apptestreign.data.database.entities.HackNewsEntity
import com.dahlosdev.apptestreign.data.model.HackNewsModel
import java.util.*

data class HackNews(
    val objectID: String,
    val title: String?,
    val author: String,
    val story_title: String?,
    val story_url: String?,
    val created_at: String
)

fun HackNewsModel.toDomain() =
    HackNews(
        objectID,
        title,
        author,
        story_title,
        story_url,
        created_at.toString()
    )

fun HackNewsEntity.toDomain() =
    HackNews(objectID, title, author, story_title, story_url, created_at)