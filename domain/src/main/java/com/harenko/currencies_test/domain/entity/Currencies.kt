package com.harenko.currencies_test.domain.entity

data class Currencies(
        val baseCurrency: BaseCurrency,
        val currencies: List<Currency>
)