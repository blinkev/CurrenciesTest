package com.harenko.currencies_test.ui.main.main

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.harenko.currencies_test.domain.entity.BaseCurrency
import com.harenko.currencies_test.domain.entity.CurrencyCode
import com.harenko.currencies_test.domain.repo.CurrencyRepo
import com.harenko.currencies_test.ui.main.BaseViewModelImpl
import com.harenko.currencies_test.ui.main.DataStatus
import com.harenko.currencies_test.ui.main.main.di.MainActivityComponent
import com.harenko.currencies_test.ui.main.main.item.*
import com.harenko.currencies_test.ui.main.toDataStatus
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.math.BigDecimal
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by egor.kharenko
on 24/12/2018.
 */

class MainActivityViewModelImpl @Inject constructor() : BaseViewModelImpl<MainActivityComponent>(),
        MainActivityViewModel {

    companion object {
        private val defaultCurrency = BaseCurrency(code = CurrencyCode.EUR, multiplier = BigDecimal(1))
    }

    @Inject
    lateinit var currencyRepo: CurrencyRepo
    @Inject
    lateinit var requestResultsUiMapper: RequestResultsUiMapper
    @Inject
    lateinit var newMultiplierUiMapper: NewMultiplierUiMapper
    @Inject
    lateinit var data: MainActivityViewModelData

    override val currencies = MutableLiveData<DataStatus<UiData>>()

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun requestCurrencies() {
        requestCurrencies(data.baseCurrency ?: defaultCurrency)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stopRequestingCurrencies() {
        compositeDisposable.clear()
    }

    private fun requestCurrencies(baseCurrency: BaseCurrency) {
        currencyRepo.getCurrencies(baseCurrency)
                .map {
                    val isBaseCurrencyChanged = data.baseCurrency?.code != baseCurrency.code
                    data.baseCurrency = baseCurrency
                    requestResultsUiMapper.map(isBaseCurrencyChanged, it)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .retryWhen {
                    it.flatMap { error ->
                        currencies.value = error.toDataStatus()
                        Observable.timer(1, TimeUnit.SECONDS)
                    }
                }
                .trackAndSubscribe(operationId = currencyRepo.hashCode()) { result: DataStatus<UiData> ->
                    currencies.value = result
                }
    }

    override fun changeBaseCurrency(item: CurrencyUiItem) {
        compositeDisposable.clear()
        requestCurrencies(BaseCurrency(code = item.code, multiplier = item.multipliedRate))
    }

    override fun changeMultiplier(multiplier: BigDecimal) {
        if (multiplier == data.baseCurrency?.multiplier) return

        (currencies.value as? DataStatus.Data)?.let { currentUiData ->
            compositeDisposable.clear()

            val data = currentUiData.data
            currencies.value = UiData(
                    isBaseCurrencyChanged = false,
                    baseCurrencyItem = data.baseCurrencyItem,
                    currencyList = data.currencyList.map {
                        newMultiplierUiMapper.map(multiplier, it)
                    }
            ).toDataStatus()
        }

        data.baseCurrency?.let { baseCurrency ->
            requestCurrencies(baseCurrency.copy(multiplier = multiplier))
        }
    }
}