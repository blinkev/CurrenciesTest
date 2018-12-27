package com.harenko.currencies_test.ui.main.di

import com.harenko.currencies_test.domain.di.DomainProvider
import com.harenko.currencies_test.ui.main.main.di.MainActivityComponent
import com.harenko.currencies_test.ui.main.main.di.MainActivityModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by egor.kharenko
on 24/12/2018.
 */

@Singleton
@Component(dependencies = [DomainProvider::class])
interface UiComponent {
    fun provideMainActivityComponent(module: MainActivityModule): MainActivityComponent
}