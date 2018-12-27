package com.harenko.currencies_test.ui.main.main.item

import com.harenko.currencies_test.domain.entity.BaseCurrency
import com.harenko.currencies_test.domain.entity.Currencies
import com.harenko.currencies_test.domain.entity.Currency
import com.harenko.currencies_test.ui.main.dotsToCommas
import java.math.BigDecimal
import java.math.RoundingMode
import javax.inject.Inject

class RequestResultsUiMapperImpl @Inject constructor(
        private val detailsProvider: CurrencyDetailsProvider
) : RequestResultsUiMapper {

    override fun map(isBaseCurrencyChanged: Boolean, currencies: Currencies): UiData {
        return UiData(
                isBaseCurrencyChanged = isBaseCurrencyChanged,
                baseCurrencyItem = createBasedUiItem(basedCurrency = currencies.baseCurrency),
                currencyList = currencies.currencies.map {
                    createUiItem(entity = it, multiplier = currencies.baseCurrency.multiplier)
                }
        )
    }

    private fun createBasedUiItem(basedCurrency: BaseCurrency): BaseCurrencyUiItem {
        val multiplierFormatted = basedCurrency.multiplier
                .setScale(2, RoundingMode.DOWN)
                .toString()
                .dotsToCommas()

        return BaseCurrencyUiItem(
                code = basedCurrency.code,
                description = detailsProvider.getDescription(basedCurrency.code),
                flagUrl = detailsProvider.getFlagUrl(basedCurrency.code),
                multiplierFormatted = multiplierFormatted
        )
    }

    private fun createUiItem(entity: Currency, multiplier: BigDecimal): CurrencyUiItem {
        val multipliedRate = entity.rate.multiply(multiplier)
        val multipliedRateFormatted = multipliedRate
                .setScale(2, RoundingMode.DOWN)
                .toString()
                .dotsToCommas()

        return CurrencyUiItem(
                code = entity.code,
                rate = entity.rate,
                multipliedRate = multipliedRate,
                description = detailsProvider.getDescription(entity.code),
                flagUrl = detailsProvider.getFlagUrl(entity.code),
                multipliedRateFormatted = multipliedRateFormatted
        )
    }
}