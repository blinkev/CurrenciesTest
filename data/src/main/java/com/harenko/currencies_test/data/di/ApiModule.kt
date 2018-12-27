package com.harenko.currencies_test.data.di

import com.harenko.currencies_test.data.api.CurrencyApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by egor.kharenko
on 24/12/2018.
 */

@Module
class ApiModule {

    @Singleton
    @Provides
    fun provideCurrencyApi(retrofit: Retrofit): CurrencyApi = retrofit.create(CurrencyApi::class.java)
}