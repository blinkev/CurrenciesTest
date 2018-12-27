package com.harenko.currencies_test.data.di

import com.harenko.currencies_test.data.dto.CurrenciesRatesDtoToEntityMapper
import com.harenko.currencies_test.data.dto.CurrenciesRatesDtoToEntityMapperImpl
import com.harenko.currencies_test.data.query.CurrenciesQueryImpl
import com.harenko.currencies_test.domain.repo.CurrenciesQuery
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by egor.kharenko
on 24/12/2018.
 */

@Module
class QueryModule {

    @Singleton
    @Provides
    fun provideCurrenciesQuery(query: CurrenciesQueryImpl): CurrenciesQuery = query
}