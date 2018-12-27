package com.harenko.currencies_test.data.query

import com.harenko.currencies_test.data.api.CurrencyApi
import com.harenko.currencies_test.data.dto.CurrenciesRatesDtoToEntityMapper
import com.harenko.currencies_test.domain.entity.BaseCurrency
import com.harenko.currencies_test.domain.entity.Currency
import com.harenko.currencies_test.domain.entity.CurrencyCode
import com.harenko.currencies_test.domain.repo.CurrenciesQuery
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by egor.kharenko
on 24/12/2018.
 */

class CurrenciesQueryImpl @Inject constructor(
        private val api: CurrencyApi,
        private val mapper: CurrenciesRatesDtoToEntityMapper
) : CurrenciesQuery {

    override fun getCurrenciesForBase(baseCurrency: BaseCurrency): Observable<List<Currency>> =
            api.getCurrencies(baseCurrency.code).map {
                mapper.map(it.rates)
            }
}