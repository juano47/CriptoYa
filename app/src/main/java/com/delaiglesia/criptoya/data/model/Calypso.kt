package com.delaiglesia.criptoya.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Calypso(
    @PrimaryKey(autoGenerate = true)
    val idCalypso: Int = 0,
    @SerializedName("ask")
    val askCalypso: Double?,
    @SerializedName("bid")
    val bidCalypso: Double?,
    @SerializedName("time")
    val timeCalypso: Double?,
    @SerializedName("totalAsk")
    val totalAskCalypso: Double?,
    @SerializedName("totalBid")
    val totalBidCalypso: Double?
)