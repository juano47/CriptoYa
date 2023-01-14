package com.delaiglesia.criptoya.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.delaiglesia.criptoya.data.utils.Currency
import com.google.gson.annotations.SerializedName

@Entity(tableName = "crypto_price")
data class CryptoPricesResponse(

    @PrimaryKey
    @SerializedName("crypto")
    var crypto: Currency,

    @Embedded(prefix = "bitex_")
    @SerializedName("bitex")
    val bitex: Exchange?,

    @Embedded(prefix = "bitso_")
    @SerializedName("bitso")
    val bitso: Exchange?,

    @Embedded(prefix = "calypso_")
    @SerializedName("calypso")
    val calypso: Exchange?,

    @Embedded(prefix = "decrypto_")
    @SerializedName("decrypto")
    val decrypto: Exchange?,

    @Embedded(prefix = "fiwind_")
    @SerializedName("fiwind")
    val fiwind: Exchange?,

    @Embedded(prefix = "fluyez_")
    @SerializedName("fluyez")
    val fluyez: Exchange?,

    @Embedded(prefix = "letsbit_")
    @SerializedName("letsbit")
    val letsbit: Exchange?,

    @Embedded(prefix = "tiendacrypto_")
    @SerializedName("tiendacrypto")
    val tiendaCrypto: Exchange?,

    @Embedded(prefix = "vitawallet_")
    @SerializedName("vitawallet")
    val vitawallet: Exchange?
)