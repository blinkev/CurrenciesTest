package com.harenko.currencies_test.domain.entity

/**
 * Created by egor.kharenko
on 24/12/2018.
 */

enum class CurrencyCode(val countryCode: String, val description: String) {
    AUD("AU", "Australian dollar"),
    BGN("BG", "Bulgarian lev"),
    BRL("BR", "Brazilian real"),
    CAD("CA", "Canadian dollar"),
    CHF("CH", "Swiss franc"),
    CNY("CN", "Renminbi"),
    CZK("CZ", "Czech koruna"),
    DKK("DK", "Danish krone"),
    EUR("EU", "Euro"),
    GBP("GB", "Pound sterling"),
    HKD("HK", "Hong Kong dollar"),
    HRK("HR", "Croatian kuna"),
    HUF("HU", "Hungarian forint"),
    IDR("ID", "Indonesian rupiah"),
    ILS("IL", "Israeli new shekel"),
    INR("IN", "Indian rupee"),
    ISK("IS", "Icelandic króna"),
    JPY("JP", "Japanese yen"),
    KRW("KR", "South Korean won"),
    MXN("MX", "Mexican peso"),
    MYR("MY", "Malaysian ringgit"),
    NOK("NO", "Norwegian krone"),
    NZD("NZ", "New Zealand dollar"),
    PHP("PH", "Philippine peso"),
    PLN("PL", "Polish złoty"),
    RON("RO", "Romanian leu"),
    RUB("RU", "Russian ruble"),
    SEK("SE", "Swedish krona"),
    SGD("SG", "Singapore dollar"),
    THB("TH", "Thai baht"),
    TRY("TR", "Turkish lira"),
    USD("US", "United States Dollar"),
    ZAR("ZA", "South African rand")
}