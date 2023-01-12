package com.delaiglesia.criptoya.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Letsbit(
    @PrimaryKey(autoGenerate = true)
    val idLetsbit: Int = 0,
    @SerializedName("ask")
    val askLetsbit: Double?,
    @SerializedName("bid")
    val bidLetsbit: Double?,
    @SerializedName("time")
    val timeLetsbit: Double?,
    @SerializedName("totalAsk")
    val totalAskLetsbit: Double?,
    @SerializedName("totalBid")
    val totalBidLetsbit: Double?
)