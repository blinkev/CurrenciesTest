package com.harenko.currencies_test.data.dto

/**
 * Created by egor.kharenko
on 24/12/2018.
 */

data class GetCurrenciesResp(
        val rates: CurrenciesRatesDto
) {

    data class CurrenciesRatesDto(
            val rates: List<CurrencyDto>
            /*val aud: Double,
            val bgn: Double,
            val brl: Double,
            val cad: Double,
            val chf: Double,
            val cny: Double,
            val czk: Double,
            val dkk: Double,
            val gbp: Double,
            val hkd: Double,
            val hrk: Double,
            val huf: Double,
            val idr: Double,
            val ils: Double,
            val inr: Double,
            val isk: Double,
            val jpy: Double,
            val krw: Double,
            val mxn: Double,
            val myr: Double,
            val nok: Double,
            val nzd: Double,
            val php: Double,
            val pln: Double,
            val ron: Double,
            val rub: Double,
            val sek: Double,
            val sgd: Double,
            val thb: Double,
            val `try`: Double,
            val usd: Double,
            val zar: Double*/
    )
}