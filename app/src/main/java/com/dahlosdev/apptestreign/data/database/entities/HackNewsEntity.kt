package com.dahlosdev.apptestreign.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dahlosdev.apptestreign.domain.model.HackNews

@Entity(tableName = "hack_news_table")
data class HackNewsEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "objectID") val objectID: String,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "author") val author: String,
    @ColumnInfo(name = "story_title") val story_title: String?,
    @ColumnInfo(name = "story_url") val story_url: String?,
    @ColumnInfo(name = "created_at") val created_at: String
)

fun HackNews.toDatabase() = HackNewsEntity(
    objectID = objectID,
    title = title,
    author = author,
    story_title = story_title,
    story_url = story_url,
    created_at = created_at.toString()
)