package com.harenko.currencies_test.ui.main.main.item

import com.harenko.currencies_test.domain.entity.Currencies
import java.math.BigDecimal

/**
 * Created by egor.kharenko
on 24/12/2018.
 */

interface NewMultiplierUiMapper {
    fun map(multiplier: BigDecimal, item: CurrencyUiItem): CurrencyUiItem
}