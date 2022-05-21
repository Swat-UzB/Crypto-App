package com.swat_uzb.cryptoapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.swat_uzb.cryptoapp.databinding.ItemCoinInfoBinding
import com.swat_uzb.cryptoapp.pojo.CoinPriceInfo

class CoinPriceAdapter() :
    ListAdapter<CoinPriceInfo, CoinPriceViewHolder>(CoinPriceDiffUtil<CoinPriceInfo>()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinPriceViewHolder {
        val binding =
            ItemCoinInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CoinPriceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinPriceViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bindData(currentItem)
        holder.itemView.setOnClickListener {
            onItemClickListener?.let { click ->
                click(currentItem)
            }
        }
    }

    private  var onItemClickListener: ((CoinPriceInfo) -> Unit)? = null

    fun setOnItemClickListener(listener: (CoinPriceInfo) -> Unit) {
        this.onItemClickListener = listener
    }
}