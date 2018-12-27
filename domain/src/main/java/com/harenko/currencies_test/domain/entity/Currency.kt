package com.harenko.currencies_test.domain.entity

import java.math.BigDecimal

/**
 * Created by egor.kharenko
on 24/12/2018.
 */

data class Currency(
        val code: CurrencyCode,
        val rate: BigDecimal
)