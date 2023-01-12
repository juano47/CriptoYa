package com.delaiglesia.criptoya.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Fiwind(
    @PrimaryKey(autoGenerate = true)
    val idFiwind: Int = 0,
    @SerializedName("ask")
    val askFiwind: Double?,
    @SerializedName("bid")
    val bidFiwind: Double?,
    @SerializedName("time")
    val timeFiwind: Double?,
    @SerializedName("totalAsk")
    val totalAskFiwind: Double?,
    @SerializedName("totalBid")
    val totalBidFiwind: Double?
)