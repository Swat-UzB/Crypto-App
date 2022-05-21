package com.swat_uzb.cryptoapp.api

import com.swat_uzb.cryptoapp.pojo.CoinInfoListOfData
import com.swat_uzb.cryptoapp.pojo.CoinPriceInfoRawData
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top/totalvolfull")
    fun getTopCoinsInfo(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = API_KEY,
        @Query(QUERY_PARAM_LIMIT) limit: Int = 10,
        @Query(QUERY_PARAM_TO_SYMBOL) tSym: String = CURRENCY
    ): Single<CoinInfoListOfData>

    @GET("pricemultifull")
    fun getFullPriceList(
        @Query(QUERY_PARAM_FROM_SYMBOLS) fSyms: String,
        @Query(QUERY_PARAM_TO_SYMBOLS) tSyms: String = CURRENCY,
        @Query(QUERY_PARAM_API_KEY) apiKey: String = API_KEY
    ): Single<CoinPriceInfoRawData>


    companion object {

        private const val QUERY_PARAM_LIMIT = "limit"
        private const val QUERY_PARAM_TO_SYMBOL = "tsym"
        private const val QUERY_PARAM_TO_SYMBOLS = "tsyms"
        private const val QUERY_PARAM_FROM_SYMBOLS = "fsyms"
        private const val QUERY_PARAM_API_KEY = "api_key"
        private const val CURRENCY = "USD"
        private const val API_KEY =
            "b8d98d088763c3980fa0193124676610c246d29ead059284c05b72dcd7da554f"
        const val BASE_URL = "https://min-api.cryptocompare.com/data/"
        const val BASE_IMAGE_URL = "https://cryptocompare.com"
    }
}