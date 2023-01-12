package com.delaiglesia.criptoya.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Bitex(
    @PrimaryKey(autoGenerate = true)
    val idBitex: Int = 0,
    @SerializedName("ask")
    val askBitex: Double?,
    @SerializedName("bid")
    val bidBitex: Double?,
    @SerializedName("time")
    val timeBitex: Double?,
    @SerializedName("totalAsk")
    val totalAskBitex: Double?,
    @SerializedName("totalBid")
    val totalBidBitex: Double?
)