package com.harenko.currencies_test.ui.main.main.di

import com.harenko.currencies_test.ui.main.ViewModelScope
import com.harenko.currencies_test.ui.main.main.MainActivityViewModel
import com.harenko.currencies_test.ui.main.main.MainActivityViewModelData
import com.harenko.currencies_test.ui.main.main.MainActivityViewModelDataImpl
import com.harenko.currencies_test.ui.main.main.item.*
import dagger.Module
import dagger.Provides

/**
 * Created by egor.kharenko
on 24/12/2018.
 */

@Module
class MainActivityModule(private val viewModel: MainActivityViewModel) {

    @ViewModelScope
    @Provides
    fun provideViewModel(): MainActivityViewModel = viewModel

    @ViewModelScope
    @Provides
    fun provideRequestResultsUiMapper(mapper: RequestResultsUiMapperImpl): RequestResultsUiMapper = mapper

    @ViewModelScope
    @Provides
    fun provideNewMultiplierUiMapper(mapper: NewMultiplierUiMapperImpl): NewMultiplierUiMapper =
            mapper

    @ViewModelScope
    @Provides
    fun provideViewModelData(data: MainActivityViewModelDataImpl): MainActivityViewModelData = data

    @ViewModelScope
    @Provides
    fun provideCurrencyDetailsProvider(provider: CurrencyDetailsProviderImpl)
            : CurrencyDetailsProvider = provider
}