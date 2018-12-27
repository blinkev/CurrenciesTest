package com.harenko.currencies_test.data.di

import com.harenko.currencies_test.data.dto.CurrenciesRatesDtoToEntityMapper
import com.harenko.currencies_test.data.dto.CurrenciesRatesDtoToEntityMapperImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by egor.kharenko
on 24/12/2018.
 */

@Module
class MapperModule {

    @Singleton
    @Provides
    fun provideCurrenciesRatesDtoToEntityMapper(mapper: CurrenciesRatesDtoToEntityMapperImpl)
            : CurrenciesRatesDtoToEntityMapper = mapper
}