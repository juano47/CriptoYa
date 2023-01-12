package com.delaiglesia.criptoya.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Fluyez(
    @PrimaryKey(autoGenerate = true)
    val idFluyez: Int = 0,
    @SerializedName("ask")
    val askFluyez: Double?,
    @SerializedName("bid")
    val bidFluyez: Double?,
    @SerializedName("time")
    val timeFluyez: Double?,
    @SerializedName("totalAsk")
    val totalAskFluyez: Double?,
    @SerializedName("totalBid")
    val totalBidFluyez: Double?
)