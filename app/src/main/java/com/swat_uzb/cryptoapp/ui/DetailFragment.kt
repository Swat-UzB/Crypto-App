package com.swat_uzb.cryptoapp.ui

import com.squareup.picasso.Picasso
import com.swat_uzb.cryptoapp.databinding.FragmentDetailBinding


class DetailFragment : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {
    override fun onViewCreate() {
        coinViewModel.coinInfo.observe(viewLifecycleOwner) {
            binding.coinPriceInfo = it
            Picasso.get()
                .load(it.getImageUrl())
                .into(binding.imageViewLogoCoin)
        }
    }

}