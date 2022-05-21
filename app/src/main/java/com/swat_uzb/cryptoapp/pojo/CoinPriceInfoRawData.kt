package com.swat_uzb.cryptoapp.pojo

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import org.json.JSONObject


data class CoinPriceInfoRawData(
    @SerializedName("RAW")
    val coinPriceInfoRawData: JsonObject?
)
