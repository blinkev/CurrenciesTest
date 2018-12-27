package com.harenko.currencies_test.ui.main.main.item

import com.harenko.currencies_test.domain.entity.Currencies

/**
 * Created by egor.kharenko
on 24/12/2018.
 */

interface RequestResultsUiMapper {
    fun map(isBaseCurrencyChanged: Boolean, currencies: Currencies): UiData
}