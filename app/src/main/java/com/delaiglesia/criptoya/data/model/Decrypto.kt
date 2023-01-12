package com.delaiglesia.criptoya.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Decrypto(
    @PrimaryKey(autoGenerate = true)
    val idDecrypto: Int = 0,
    @SerializedName("ask")
    val askDecrypto: Double?,
    @SerializedName("bid")
    val bidDecrypto: Double?,
    @SerializedName("time")
    val timeDecrypto: Double?,
    @SerializedName("totalAsk")
    val totalAskDecrypto: Double?,
    @SerializedName("totalBid")
    val totalBidDecrypto: Double?
)