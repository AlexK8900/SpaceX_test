package com.alexk8900.spacex.data.model

import android.os.Parcelable
import com.alexk8900.spacex.data.rest.dto.Crew
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Card(
    val id: String? = "",
    val dateUtc: String? = "",
    val smallIcon: String? = "",
    val name: String? = "",
    val flight: Int? = 0,
    val status: Boolean? = false,
    val bigIcon: String? = "",
    val details: String? = "",
    var date: Date = Date(),
    val crewIds: List<String> = listOf(),
    val crew: MutableList<Crew> = mutableListOf()
) : Parcelable