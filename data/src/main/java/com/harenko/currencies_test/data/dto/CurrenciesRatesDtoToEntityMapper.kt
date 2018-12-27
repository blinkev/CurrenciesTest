package com.harenko.currencies_test.data.dto

import com.harenko.currencies_test.domain.entity.BaseCurrency
import com.harenko.currencies_test.domain.entity.Currency

/**
 * Created by egor.kharenko
on 24/12/2018.
 */

interface CurrenciesRatesDtoToEntityMapper {
    fun map(dto: GetCurrenciesResp.CurrenciesRatesDto): List<Currency>
}