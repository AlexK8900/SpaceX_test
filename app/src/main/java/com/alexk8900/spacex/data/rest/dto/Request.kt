package com.alexk8900.spacex.data.rest.dto

import com.google.gson.annotations.SerializedName

class Request(
    @SerializedName("query")
    val query: Query,
    @SerializedName("options")
    val options: Options)