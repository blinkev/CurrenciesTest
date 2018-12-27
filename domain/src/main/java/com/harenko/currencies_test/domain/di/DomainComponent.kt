package com.harenko.currencies_test.domain.di

import dagger.Component
import javax.inject.Singleton

/**
 * Created by egor.kharenko
on 24/12/2018.
 */

@Singleton
@Component(dependencies = [DomainDependencies::class], modules = [RepoModule::class])
interface DomainComponent : DomainProvider