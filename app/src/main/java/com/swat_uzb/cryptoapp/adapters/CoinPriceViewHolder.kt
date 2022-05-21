package com.swat_uzb.cryptoapp.adapters

import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.swat_uzb.cryptoapp.databinding.ItemCoinInfoBinding
import com.swat_uzb.cryptoapp.pojo.CoinPriceInfo

class CoinPriceViewHolder(private val binding: ItemCoinInfoBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindData(coinPriceInfo: CoinPriceInfo) {
        binding.coinPriceInfo = coinPriceInfo
        Picasso.get()
            .load(coinPriceInfo.getImageUrl())
            .into(binding.imageViewLogoCoin)
    }
}