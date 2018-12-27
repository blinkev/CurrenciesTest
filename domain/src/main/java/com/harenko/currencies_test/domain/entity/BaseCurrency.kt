package com.harenko.currencies_test.domain.entity

import java.math.BigDecimal

data class BaseCurrency(val code: CurrencyCode, val multiplier: BigDecimal)