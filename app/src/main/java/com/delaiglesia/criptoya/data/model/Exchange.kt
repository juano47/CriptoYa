package com.delaiglesia.criptoya.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Exchange(
    @SerializedName("ask")
    val ask: Double?,
    @SerializedName("bid")
    val bid: Double?,
    @SerializedName("time")
    val time: Double?,
    @SerializedName("totalAsk")
    val totalAsk: Double?,
    @SerializedName("totalBid")
    val totalBid: Double?
)