package com.harenko.currencies_test.ui.main.main.item

import com.harenko.currencies_test.domain.entity.CurrencyCode
import javax.inject.Inject

class CurrencyDetailsProviderImpl @Inject constructor() : CurrencyDetailsProvider {

    private data class Details(val countryCode: String, val description: String)

    private val flagUrl = "https://www.countryflags.io/%s/shiny/64.png"

    private val currencyData = hashMapOf(
            CurrencyCode.AUD to Details("AU", "Australian dollar"),
            CurrencyCode.BGN to Details("BG", "Bulgarian lev"),
            CurrencyCode.BRL to Details("BR", "Brazilian real"),
            CurrencyCode.CAD to Details("CA", "Canadian dollar"),
            CurrencyCode.CHF to Details("CH", "Swiss franc"),
            CurrencyCode.CNY to Details("CN", "Renminbi"),
            CurrencyCode.CZK to Details("CZ", "Czech koruna"),
            CurrencyCode.DKK to Details("DK", "Danish krone"),
            CurrencyCode.EUR to Details("EU", "Euro"),
            CurrencyCode.GBP to Details("GB", "Pound sterling"),
            CurrencyCode.HKD to Details("HK", "Hong Kong dollar"),
            CurrencyCode.HRK to Details("HR", "Croatian kuna"),
            CurrencyCode.HUF to Details("HU", "Hungarian forint"),
            CurrencyCode.IDR to Details("ID", "Indonesian rupiah"),
            CurrencyCode.ILS to Details("IL", "Israeli new shekel"),
            CurrencyCode.INR to Details("IN", "Indian rupee"),
            CurrencyCode.ISK to Details("IS", "Icelandic króna"),
            CurrencyCode.JPY to Details("JP", "Japanese yen"),
            CurrencyCode.KRW to Details("KR", "South Korean won"),
            CurrencyCode.MXN to Details("MX", "Mexican peso"),
            CurrencyCode.MYR to Details("MY", "Malaysian ringgit"),
            CurrencyCode.NOK to Details("NO", "Norwegian krone"),
            CurrencyCode.NZD to Details("NZ", "New Zealand dollar"),
            CurrencyCode.PHP to Details("PH", "Philippine peso"),
            CurrencyCode.PLN to Details("PL", "Polish złoty"),
            CurrencyCode.RON to Details("RO", "Romanian leu"),
            CurrencyCode.RUB to Details("RU", "Russian ruble"),
            CurrencyCode.SEK to Details("SE", "Swedish krona"),
            CurrencyCode.SGD to Details("SG", "Singapore dollar"),
            CurrencyCode.THB to Details("TH", "Thai baht"),
            CurrencyCode.TRY to Details("TR", "Turkish lira"),
            CurrencyCode.USD to Details("US", "United States Dollar"),
            CurrencyCode.ZAR to Details("ZA", "South African rand")
    )

    override fun getDescription(code: CurrencyCode): String = currencyData[code]?.description ?: ""

    override fun getFlagUrl(code: CurrencyCode): String = String.format(
            flagUrl,
            currencyData[code]?.countryCode
    )
}