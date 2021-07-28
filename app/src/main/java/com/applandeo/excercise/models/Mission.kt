package com.applandeo.excercise.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Mission(
    val mission_name: String? = null,
    val mission_id: String? = null,
    val manufacturers: List<String>? = listOf(),
    val payload_ids: List<String>? = listOf(),
    val wikipedia: String? = null,
    val website: String? = null,
    val twitter: String? = null,
    val description: String? = null
) : Parcelable