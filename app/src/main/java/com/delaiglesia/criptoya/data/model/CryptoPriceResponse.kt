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

    @Embedded
    @SerializedName("bitex")
    val bitex: Bitex?,

    @Embedded
    @SerializedName("bitso")
    val bitso: Bitso?,

    @Embedded
    @SerializedName("calypso")
    val calypso: Calypso?,

    @Embedded
    @SerializedName("decrypto")
    val decrypto: Decrypto?,

    @Embedded
    @SerializedName("fiwind")
    val fiwind: Fiwind?,

    @Embedded
    @SerializedName("fluyez")
    val fluyez: Fluyez?,

    @Embedded
    @SerializedName("letsbit")
    val letsbit: Letsbit?,

    @Embedded
    @SerializedName("tiendacrypto")
    val tiendaCrypto: TiendaCrypto?,

    @Embedded
    @SerializedName("vitawallet")
    val vitawallet: Vitawallet?
)