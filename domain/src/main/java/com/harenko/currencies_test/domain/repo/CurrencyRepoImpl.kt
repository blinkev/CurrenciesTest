package com.harenko.currencies_test.domain.repo

import android.util.Log
import com.harenko.currencies_test.domain.entity.BaseCurrency
import com.harenko.currencies_test.domain.entity.Currencies
import com.harenko.currencies_test.domain.entity.Currency
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.math.BigDecimal
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class CurrencyRepoImpl @Inject constructor(
        private val query: CurrenciesQuery
) : CurrencyRepo {

    override fun getCurrencies(baseCurrency: BaseCurrency): Observable<Currencies> =
            Observable.interval(0, 1, TimeUnit.SECONDS)
                    .switchMap {
                        query.getCurrenciesForBase(baseCurrency)
                                .map { currencies ->
                                    Currencies(baseCurrency = baseCurrency, currencies = currencies)
                                }
                                .subscribeOn(Schedulers.io())
                    }
}