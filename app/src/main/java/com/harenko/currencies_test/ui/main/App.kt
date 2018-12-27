package com.harenko.currencies_test.ui.main

import android.app.Application
import com.harenko.currencies_test.data.di.DaggerDataComponent
import com.harenko.currencies_test.domain.di.DaggerDomainComponent
import com.harenko.currencies_test.ui.main.di.DaggerUiComponent
import com.harenko.currencies_test.ui.main.di.UiComponent
import com.harenko.currencies_test.ui.main.di.UiComponentHolder

/**
 * Created by egor.kharenko
on 24/12/2018.
 */

class App : Application(), UiComponentHolder {

    override val uiComponent: UiComponent by lazy {
        val dataComponent = DaggerDataComponent.builder().build()

        val domainComponent = DaggerDomainComponent.builder()
                .domainDependencies(dataComponent)
                .build()

        DaggerUiComponent.builder()
                .domainProvider(domainComponent)
                .build()
    }
}