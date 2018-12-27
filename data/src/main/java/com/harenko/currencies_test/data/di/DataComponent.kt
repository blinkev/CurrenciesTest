package com.harenko.currencies_test.data.di

import com.harenko.currencies_test.domain.di.DomainDependencies
import dagger.Component
import javax.inject.Singleton

/**
 * Created by egor.kharenko
on 24/12/2018.
 */

@Singleton
@Component(modules = [ApiModule::class, MapperModule::class, RetrofitModule::class, QueryModule::class])
interface DataComponent : DomainDependencies