package com.swat_uzb.cryptoapp.ui

import androidx.navigation.fragment.findNavController
import com.swat_uzb.cryptoapp.R
import com.swat_uzb.cryptoapp.adapters.CoinPriceAdapter
import com.swat_uzb.cryptoapp.databinding.FragmentMainBinding

class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {
    private lateinit var coinPriceAdapter: CoinPriceAdapter
    override fun onViewCreate() {
        coinPriceAdapter = CoinPriceAdapter()
        binding.coinPriceListRecyclerView.adapter = coinPriceAdapter
        coinPriceAdapter.setOnItemClickListener {
            coinViewModel.setCoinInfo(it)
            findNavController().navigate(R.id.action_mainFragment_to_detailFragment)
        }
        coinViewModel.priceList.observe(this) {
            coinPriceAdapter.submitList(it)
        }
    }

}