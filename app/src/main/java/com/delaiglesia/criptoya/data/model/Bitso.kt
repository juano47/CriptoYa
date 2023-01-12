package com.delaiglesia.criptoya.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Bitso(
    @PrimaryKey(autoGenerate = true)
    val idBitso: Int = 0,
    @SerializedName("ask")
    val askBitso: Double?,
    @SerializedName("bid")
    val bidBitso: Double?,
    @SerializedName("time")
    val timeBitso: Double?,
    @SerializedName("totalAsk")
    val totalAskBitso: Double?,
    @SerializedName("totalBid")
    val totalBidBitso: Double?
)