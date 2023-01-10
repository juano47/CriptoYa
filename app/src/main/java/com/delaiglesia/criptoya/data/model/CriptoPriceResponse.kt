package com.delaiglesia.criptoya.data.model


import com.google.gson.annotations.SerializedName

data class CryptoPricesResponse(
    @SerializedName("bitex")
    val bitex: Bitex?,
    @SerializedName("bitso")
    val bitso: Bitso?,
    @SerializedName("calypso")
    val calypso: Calypso?,
    @SerializedName("decrypto")
    val decrypto: Decrypto?,
    @SerializedName("fiwind")
    val fiwind: Fiwind?,
    @SerializedName("fluyez")
    val fluyez: Fluyez?,
    @SerializedName("letsbit")
    val letsbit: Letsbit?,
    @SerializedName("tiendacrypto")
    val tiendacrypto: Tiendacrypto?,
    @SerializedName("vitawallet")
    val vitawallet: Vitawallet?
)