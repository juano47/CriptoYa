package com.delaiglesia.criptoya.data.model


import com.google.gson.annotations.SerializedName

data class Bitso(
    @SerializedName("ask")
    val ask: Int,
    @SerializedName("bid")
    val bid: Int,
    @SerializedName("time")
    val time: Int,
    @SerializedName("totalAsk")
    val totalAsk: Int,
    @SerializedName("totalBid")
    val totalBid: Int
)