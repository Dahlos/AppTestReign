package com.dahlosdev.apptestreign.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

class HitModel(
    @SerializedName("objectID") val objectID: String,
    @SerializedName("title") val title: String,
    val author: String,
    @SerializedName("story_title") val story_title: String,
    @SerializedName("story_url") val story_url: String,
    @SerializedName("created_at") val created_at: Date
) {
}