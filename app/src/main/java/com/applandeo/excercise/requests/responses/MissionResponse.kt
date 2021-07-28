package com.applandeo.excercise.requests.responses

import com.google.gson.annotations.SerializedName

class MissionResponse (
    @SerializedName("mission_name")
    val mission_name: String,

    @SerializedName("mission_id")
    val mission_id: String,

    @SerializedName("manufacturers")
    val manufacturers: List<String>,

    @SerializedName("payload_ids")
    val payload_ids: List<String>,

    @SerializedName("wikipedia")
    val wikipedia: String,

    @SerializedName("website")
    val website: String,

    @SerializedName("twitter")
    val twitter: String,

    @SerializedName("description")
    val description: String

    ){
}