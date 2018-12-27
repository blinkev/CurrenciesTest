package com.harenko.currencies_test.domain.di

import com.harenko.currencies_test.domain.repo.CurrencyRepo

/**
 * Created by egor.kharenko
on 24/12/2018.
 */

interface DomainProvider {
    val currencyRepo: CurrencyRepo
}