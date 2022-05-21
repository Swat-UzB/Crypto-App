package com.swat_uzb.cryptoapp.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.swat_uzb.cryptoapp.api.ApiFactory
import com.swat_uzb.cryptoapp.database.AppDatabase
import com.swat_uzb.cryptoapp.pojo.CoinPriceInfo
import com.swat_uzb.cryptoapp.pojo.CoinPriceInfoRawData
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit


class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getInstance(application)
    private val compositeDisposable = CompositeDisposable()
    val priceList = db.getCoinPriceDao().getPriceList()
    private val _coinInfo = MutableLiveData<CoinPriceInfo>()
    val coinInfo: LiveData<CoinPriceInfo>
        get() = _coinInfo

    fun setCoinInfo(coinPriceInfo: CoinPriceInfo) {
        _coinInfo.postValue(coinPriceInfo)
    }

    fun getDetailInfo(fSym: String): LiveData<CoinPriceInfo> {
        return db.getCoinPriceDao().getPriceInfoAboutCoin(fSym)
    }

    init {
        loadData()
    }


    private fun loadData() {
        val disposable = ApiFactory.apiService.getTopCoinsInfo(limit = 50)
            .map { it.datum?.map { it.coinInfo?.name }?.joinToString(",")!! }
            .flatMap { it?.let { it1 -> ApiFactory.apiService.getFullPriceList(fSyms = it1) } }
            .map { getPriceListFromRawData(it) }
            .delaySubscription(20, TimeUnit.SECONDS)
            .repeat()
            .retry()
            .subscribeOn(Schedulers.io())
            .subscribe({
                db.getCoinPriceDao().insertPriceList(it)
                Log.d("LOADING_DATA", "Success $it")
            }, {
                Log.d("LOADING_DATA", "Fail  ${it.message}")
            })
        compositeDisposable.add(disposable)
    }

    private fun getPriceListFromRawData(
        coinPriceInfoRawData: CoinPriceInfoRawData
    ): List<CoinPriceInfo> {
        val result = ArrayList<CoinPriceInfo>()
        val jsonObject = coinPriceInfoRawData.coinPriceInfoRawData ?: return result
        val coinKeySet = jsonObject.keySet()
        for (i in coinKeySet) {
            val currencyJson = jsonObject.getAsJsonObject(i)
            val currencyKeySet = currencyJson.keySet()
            for (k in currencyKeySet) {
                val priceInfo = Gson().fromJson(
                    currencyJson.getAsJsonObject(k),
                    CoinPriceInfo::class.java
                )
                result.add(priceInfo)
            }
        }
        return result
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}