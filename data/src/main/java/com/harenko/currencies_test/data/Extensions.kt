package com.harenko.currencies_test.data

import io.reactivex.Observable

/**
 * Created by egor.kharenko
on 13/09/2018.
 */

inline fun <reified T : Enum<T>> valueOfSafe(value: String?): T? =
        value?.let { enumValues<T>().find { it.name == value } }
