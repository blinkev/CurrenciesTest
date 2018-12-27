package com.harenko.currencies_test.ui.main.main

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import com.harenko.currencies_test.ui.main.BaseViewModel
import com.harenko.currencies_test.ui.main.DataStatus
import com.harenko.currencies_test.ui.main.main.di.MainActivityComponent
import com.harenko.currencies_test.ui.main.main.item.CurrencyUiItem
import com.harenko.currencies_test.ui.main.main.item.UiData
import java.math.BigDecimal

/**
 * Created by egor.kharenko
on 24/12/2018.
 */

interface MainActivityViewModel : BaseViewModel<MainActivityComponent>, LifecycleObserver {
    val currencies: LiveData<DataStatus<UiData>>

    fun changeBaseCurrency(item: CurrencyUiItem)
    fun changeMultiplier(multiplier: BigDecimal)
}