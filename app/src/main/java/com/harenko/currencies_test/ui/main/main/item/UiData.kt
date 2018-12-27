package com.harenko.currencies_test.ui.main.main.item

import com.github.nitrico.lastadapter.StableId


data class UiData(
        val isBaseCurrencyChanged: Boolean,
        val baseCurrencyItem: BaseCurrencyUiItem,
        val currencyList: List<CurrencyUiItem>
)