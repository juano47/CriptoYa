package com.delaiglesia.criptoya.data.model


import com.google.gson.annotations.SerializedName

data class Fiwind(
    @SerializedName("ask")
    val ask: Double,
    @SerializedName("bid")
    val bid: Double,
    @SerializedName("time")
    val time: Double,
    @SerializedName("totalAsk")
    val totalAsk: Double,
    @SerializedName("totalBid")
    val totalBid: Double
)