package com.harenko.currencies_test.data.dto

import com.harenko.currencies_test.data.valueOfSafe
import com.harenko.currencies_test.domain.entity.BaseCurrency
import com.harenko.currencies_test.domain.entity.Currency
import com.harenko.currencies_test.domain.entity.CurrencyCode
import java.math.BigDecimal
import javax.inject.Inject

class CurrenciesRatesDtoToEntityMapperImpl @Inject constructor() : CurrenciesRatesDtoToEntityMapper {

    override fun map(dto: GetCurrenciesResp.CurrenciesRatesDto): List<Currency> {

        return dto.rates.mapNotNull { currencyDto ->
            valueOfSafe<CurrencyCode>(currencyDto.name)?.let { currencyCode ->
                Currency(
                        code = currencyCode,
                        rate = BigDecimal(currencyDto.rateBasedOnEur)
                )
            }
        }
    }
}