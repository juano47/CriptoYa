package com.delaiglesia.criptoya.data.model


import com.google.gson.annotations.SerializedName

data class Letsbit(
    @SerializedName("ask")
    val ask: Double,
    @SerializedName("bid")
    val bid: Int,
    @SerializedName("time")
    val time: Int,
    @SerializedName("totalAsk")
    val totalAsk: Double,
    @SerializedName("totalBid")
    val totalBid: Int
)