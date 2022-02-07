package com.dahlosdev.apptestreign.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class HackNewsModel(
    val objectID: String,
    val title: String,
    val author: String,
    val story_title: String,
    val story_url: String,
    val created_at: Date
)