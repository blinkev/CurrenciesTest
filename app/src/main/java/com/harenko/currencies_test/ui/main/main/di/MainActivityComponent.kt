package com.harenko.currencies_test.ui.main.main.di

import com.harenko.currencies_test.ui.main.ViewModelScope
import com.harenko.currencies_test.ui.main.main.MainActivity
import com.harenko.currencies_test.ui.main.main.MainActivityViewModelImpl
import dagger.Subcomponent

/**
 * Created by egor.kharenko
on 24/12/2018.
 */

@ViewModelScope
@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent {
    fun inject(activity: MainActivity)
    fun inject(viewModel: MainActivityViewModelImpl)
}