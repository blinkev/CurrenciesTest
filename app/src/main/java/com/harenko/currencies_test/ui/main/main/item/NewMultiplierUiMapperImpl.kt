package com.harenko.currencies_test.ui.main.main.item

import com.harenko.currencies_test.ui.main.dotsToCommas
import java.math.BigDecimal
import java.math.RoundingMode
import javax.inject.Inject

class NewMultiplierUiMapperImpl @Inject constructor(
        private val detailsProvider: CurrencyDetailsProvider
) : NewMultiplierUiMapper {

    override fun map(multiplier: BigDecimal, item: CurrencyUiItem): CurrencyUiItem {
        val multipliedRate = item.rate.multiply(multiplier)
        val multipliedRateFormatted = multipliedRate
                .setScale(2, RoundingMode.DOWN)
                .toString()
                .dotsToCommas()

        return CurrencyUiItem(
                code = item.code,
                rate = item.rate,
                multipliedRate = multipliedRate,
                description = detailsProvider.getDescription(item.code),
                flagUrl = detailsProvider.getFlagUrl(item.code),
                multipliedRateFormatted = multipliedRateFormatted
        )
    }
}