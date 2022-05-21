package com.swat_uzb.cryptoapp.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.swat_uzb.cryptoapp.api.ApiService.Companion.BASE_IMAGE_URL
import com.swat_uzb.cryptoapp.utils.convertTimestampToTime

@Entity(tableName = "full_price_list")
data class CoinPriceInfo(
    @SerializedName("TYPE")
    val type: String?,
    @SerializedName("MARKET")
    val market: String?,
    @PrimaryKey
    @SerializedName("FROMSYMBOL")
    val fromsymbol: String,
    @SerializedName("TOSYMBOL")
    val tosymbol: String?,
    @SerializedName("FLAGS")
    val flags: String?,
    @SerializedName("PRICE")
    val price: Double?,
    @SerializedName("LASTUPDATE")
    val lastupdate: Long?,
    @SerializedName("MEDIAN")
    val median: Double?,
    @SerializedName("LASTVOLUME")
    val lastvolume: Double?,
    @SerializedName("LASTVOLUMETO")
    val lastvolumeto: Double?,
    @SerializedName("LASTTRADEID")
    val lasttradeid: String?,
    @SerializedName("VOLUMEDAY")
    val volumeday: Double?,
    @SerializedName("VOLUMEDAYTO")
    val volumedayto: Double?,
    @SerializedName("VOLUME24HOUR")
    val volume24hour: Double?,
    @SerializedName("VOLUME24HOURTO")
    val volume24hourto: Double?,
    @SerializedName("OPENDAY")
    val openday: Double?,
    @SerializedName("HIGHDAY")
    val highday: Double?,
    @SerializedName("LOWDAY")
    val lowday: Double?,
    @SerializedName("OPEN24HOUR")
    val open24hour: Double?,
    @SerializedName("HIGH24HOUR")
    val high24hour: Double?,
    @SerializedName("LOW24HOUR")
    val low24hour: Double?,
    @SerializedName("LASTMARKET")
    val lastmarket: String?,
    @SerializedName("VOLUMEHOUR")
    val volumehour: Double?,
    @SerializedName("VOLUMEHOURTO")
    val volumehourto: Double?,
    @SerializedName("OPENHOUR")
    val openhour: Double?,
    @SerializedName("HIGHHOUR")
    val highhour: Double?,
    @SerializedName("LOWHOUR")
    val lowhour: Double?,
    @SerializedName("TOPTIERVOLUME24HOUR")
    val toptiervolume24hour: Double?,
    @SerializedName("TOPTIERVOLUME24HOURTO")
    val toptiervolume24hourto: Double?,
    @SerializedName("CHANGE24HOUR")
    val change24hour: Double?,
    @SerializedName("CHANGEPCT24HOUR")
    val changepct24hour: Double?,
    @SerializedName("CHANGEDAY")
    val changeday: Double?,
    @SerializedName("CHANGEPCTDAY")
    val changepctday: Double?,
    @SerializedName("CHANGEHOUR")
    val changehour: Double?,
    @SerializedName("CHANGEPCTHOUR")
    val changepcthour: Double?,
    @SerializedName("CONVERSIONTYPE")
    val conversiontype: String?,
    @SerializedName("CONVERSIONSYMBOL")
    val conversionsymbol: String?,
    @SerializedName("SUPPLY")
    val supply: Int?,
    @SerializedName("MKTCAP")
    val mktcap: Double?,
    @SerializedName("MKTCAPPENALTY")
    val mktcappenalty: Int?,
    @SerializedName("CIRCULATINGSUPPLY")
    val circulatingsupply: Int?,
    @SerializedName("CIRCULATINGSUPPLYMKTCAP")
    val circulatingsupplymktcap: Double?,
    @SerializedName("TOTALVOLUME24H")
    val totalvolume24h: Double?,
    @SerializedName("TOTALVOLUME24HTO")
    val totalvolume24hto: Double?,
    @SerializedName("TOTALTOPTIERVOLUME24H")
    val totaltoptiervolume24h: Double?,
    @SerializedName("TOTALTOPTIERVOLUME24HTO")
    val totaltoptiervolume24hto: Double?,
    @SerializedName("IMAGEURL")
    val imageurl: String?
) {
    fun getFormattedTime() = convertTimestampToTime(lastupdate)
    fun getImageUrl() = BASE_IMAGE_URL + imageurl
}
