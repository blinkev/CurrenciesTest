package com.harenko.currencies_test.data.dto

/**
 * Created by egor.kharenko
on 24/12/2018.
 */

data class GetCurrenciesResp(val rates: CurrenciesRatesDto) {
    data class CurrenciesRatesDto(val rates: List<CurrencyDto>)
}