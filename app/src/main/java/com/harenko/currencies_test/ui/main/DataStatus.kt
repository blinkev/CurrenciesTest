package com.harenko.currencies_test.ui.main

/**
 * Created by egor.kharenko
on 24/12/2018.
 */

sealed class DataStatus<T> {
    data class Data<T> internal constructor(val data: T) : DataStatus<T>()
    data class Error<T> internal constructor(val error: Throwable) : DataStatus<T>()

    companion object {
        fun <T> data(data: T): DataStatus<T> = Data(data)
        fun <T> error(error: Throwable): DataStatus<T> = Error(error)
    }
}