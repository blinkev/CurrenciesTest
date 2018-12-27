package com.harenko.currencies_test.ui.main.main.item

import com.github.nitrico.lastadapter.StableId
import com.harenko.currencies_test.domain.entity.Currency
import com.harenko.currencies_test.domain.entity.CurrencyCode
import java.math.BigDecimal

/**
 * Created by egor.kharenko
on 24/12/2018.
 */

data class BaseCurrencyUiItem(
        val code: CurrencyCode,
        val description: String,
        val flagUrl: String,
        val multiplierFormatted: String,

        var multiplierTyped: String = multiplierFormatted
) : StableId {

    override val stableId: Long = (code.name + description).hashCode().toLong()
}