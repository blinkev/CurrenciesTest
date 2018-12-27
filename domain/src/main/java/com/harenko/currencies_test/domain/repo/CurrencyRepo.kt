package com.harenko.currencies_test.domain.repo

import com.harenko.currencies_test.domain.entity.BaseCurrency
import com.harenko.currencies_test.domain.entity.Currencies
import com.harenko.currencies_test.domain.entity.Currency
import com.harenko.currencies_test.domain.entity.CurrencyCode
import io.reactivex.Observable

/**
 * Created by egor.kharenko
on 24/12/2018.
 */

interface CurrencyRepo {
    fun getCurrencies(baseCurrency: BaseCurrency): Observable<Currencies>
}