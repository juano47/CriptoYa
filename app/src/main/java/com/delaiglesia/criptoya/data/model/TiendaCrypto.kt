package com.delaiglesia.criptoya.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class TiendaCrypto(
    @PrimaryKey(autoGenerate = true)
    val idTiendaCrypto: Int = 0,
    @SerializedName("ask")
    val askTiendaCrypto: Double?,
    @SerializedName("bid")
    val bidTiendaCrypto: Double?,
    @SerializedName("time")
    val timeTiendaCrypto: Double?,
    @SerializedName("totalAsk")
    val totalAskTiendaCrypto: Double?,
    @SerializedName("totalBid")
    val totalBidTiendaCrypto: Double?
)