package com.delaiglesia.criptoya.data.model


import com.google.gson.annotations.SerializedName

data class Calypso(
    @SerializedName("ask")
    val ask: Double,
    @SerializedName("bid")
    val bid: Double,
    @SerializedName("time")
    val time: Int,
    @SerializedName("totalAsk")
    val totalAsk: Double,
    @SerializedName("totalBid")
    val totalBid: Double
)