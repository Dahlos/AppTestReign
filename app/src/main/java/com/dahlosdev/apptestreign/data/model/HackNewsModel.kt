package com.dahlosdev.apptestreign.data.model

import com.google.gson.annotations.SerializedName

data class HackNewsModel(
    @SerializedName("page") val page: String,
    @SerializedName("nbHits") val nbHits: String,
    @SerializedName("nbPages") val nbPages: String
) {
}