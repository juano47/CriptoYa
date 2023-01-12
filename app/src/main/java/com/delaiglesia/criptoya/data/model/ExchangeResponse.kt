package com.delaiglesia.criptoya.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.delaiglesia.criptoya.data.utils.Currency
import com.google.gson.annotations.SerializedName

@Entity(tableName = "usdt_price")
data class ExchangeResponse(
    @PrimaryKey
    var currency: Currency = Currency.USDT,
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