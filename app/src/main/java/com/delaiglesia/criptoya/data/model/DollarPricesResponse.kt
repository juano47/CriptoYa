package com.delaiglesia.criptoya.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.delaiglesia.criptoya.data.utils.Currency
import com.google.gson.annotations.SerializedName

@Entity(tableName = "dollar_price")
data class DollarPricesResponse(
    @PrimaryKey
    var currency: Currency = Currency.USD,
    @SerializedName("blue")
    val blue: Double?,
    @SerializedName("ccb")
    val ccb: Double?,
    @SerializedName("ccl")
    val ccl: Double?,
    @SerializedName("cclgd30")
    val cclgd30: Double?,
    @SerializedName("mep")
    val mep: Double?,
    @SerializedName("mepgd30")
    val mepgd30: Double?,
    @SerializedName("oficial")
    val oficial: Double?,
    @SerializedName("solidario")
    val solidario: Double?,
    @SerializedName("time")
    val time: Double?
)