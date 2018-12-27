package com.harenko.currencies_test.data.api

import com.harenko.currencies_test.data.dto.GetCurrenciesResp
import com.harenko.currencies_test.domain.entity.CurrencyCode
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by egor.kharenko
on 24/12/2018.
 */

interface CurrencyApi {

    @GET("latest")
    fun getCurrencies(@Query("base") baseCurrency: CurrencyCode): Observable<GetCurrenciesResp>
}