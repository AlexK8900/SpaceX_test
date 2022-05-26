package com.alexk8900.spacex.data.rest.dto

import com.alexk8900.spacex.data.model.Card
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CardResponseDto(
    @SerializedName("auto_update")
    @Expose
    val autoUpdate: Boolean,
    val capsules: List<String>,
    val cores: List<Core>,
    val crew: List<String>,
    @SerializedName("date_local")
    @Expose
    val dateLocal: String,
    @SerializedName("date_precision")
    @Expose
    val datePrecision: String,
    @SerializedName("date_unix")
    @Expose
    val date_unix: Int,
    @SerializedName("date_utc")
    @Expose
    val dateUtc: String,
    val details: String,
    val failures: List<Any>,
    val fairings: Any,
    @SerializedName("flight_number")
    @Expose
    val flightNumber: Int,
    val id: String,
    val launchpad: String,
    val links: Links,
    val name: String,
    val net: Boolean,
    val payloads: List<String>,
    val rocket: String,
    val ships: List<Any>,
    @SerializedName("static_fire_date_unix")
    @Expose
    val staticFireDateUnix: Int,
    @SerializedName("static_fire_date_utc")
    @Expose
    val staticFireDateUtc: String,
    val success: Boolean,
    val tdb: Boolean,
    val upcoming: Boolean,
    val window: Int
) {
    fun toModel() = Card(
        id = this.id,
        dateUtc = this.dateUtc,
        smallIcon = this.links.patch.small,
        name = this.name,
        flight = cores.first().flight,
        status = success,
        bigIcon = this.links.patch.large,
        details = details,
        crewIds = this.crew
    )
}