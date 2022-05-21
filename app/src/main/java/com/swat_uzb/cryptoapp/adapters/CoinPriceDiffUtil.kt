package com.swat_uzb.cryptoapp.adapters

import androidx.recyclerview.widget.DiffUtil

class CoinPriceDiffUtil<T> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

}