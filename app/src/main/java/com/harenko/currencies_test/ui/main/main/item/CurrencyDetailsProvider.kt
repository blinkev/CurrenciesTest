package com.harenko.currencies_test.ui.main.main.item

import com.harenko.currencies_test.domain.entity.CurrencyCode

interface CurrencyDetailsProvider {
    fun getDescription(code: CurrencyCode): String
    fun getFlagUrl(code: CurrencyCode): String
}