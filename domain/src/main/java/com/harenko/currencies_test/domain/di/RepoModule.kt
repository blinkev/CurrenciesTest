package com.harenko.currencies_test.domain.di

import com.harenko.currencies_test.domain.repo.CurrencyRepo
import com.harenko.currencies_test.domain.repo.CurrencyRepoImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by egor.kharenko
on 24/12/2018.
 */

@Module
class RepoModule {

    @Singleton
    @Provides
    fun provideCurrencyRepo(repo: CurrencyRepoImpl): CurrencyRepo = repo
}