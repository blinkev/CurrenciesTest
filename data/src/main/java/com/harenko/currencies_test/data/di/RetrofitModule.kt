package com.harenko.currencies_test.data.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.harenko.currencies_test.data.deserializer.CurrenciesRatesDeserializer
import com.harenko.currencies_test.data.dto.CurrenciesRatesDtoToEntityMapper
import com.harenko.currencies_test.data.dto.CurrenciesRatesDtoToEntityMapperImpl
import com.harenko.currencies_test.data.dto.GetCurrenciesResp
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by egor.kharenko
on 24/12/2018.
 */

@Module
class RetrofitModule {

    private val baseUrl = "https://revolut.duckdns.org/"

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
            OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build()

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder()
            .registerTypeAdapter(
                    GetCurrenciesResp.CurrenciesRatesDto::class.java,
                    CurrenciesRatesDeserializer())
            .create()

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build()
}