package com.harenko.currencies_test.ui.main.main

import com.harenko.currencies_test.domain.entity.BaseCurrency
import com.harenko.currencies_test.domain.entity.Currency
import com.harenko.currencies_test.domain.entity.CurrencyCode
import java.math.BigDecimal
import javax.inject.Inject

class MainActivityViewModelDataImpl @Inject constructor() : MainActivityViewModelData {

    override var baseCurrency: BaseCurrency? = null
}