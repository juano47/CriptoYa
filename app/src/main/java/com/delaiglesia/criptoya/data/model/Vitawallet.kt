package com.delaiglesia.criptoya.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Vitawallet(
    @PrimaryKey(autoGenerate = true)
    val idVitawallet: Int = 0,
    @SerializedName("ask")
    val askVitawallet: Double?,
    @SerializedName("bid")
    val bidVitawallet: Double?,
    @SerializedName("time")
    val timeVitawallet: Double?,
    @SerializedName("totalAsk")
    val totalAskVitawallet: Double?,
    @SerializedName("totalBid")
    val totalBidVitawallet: Double?
)