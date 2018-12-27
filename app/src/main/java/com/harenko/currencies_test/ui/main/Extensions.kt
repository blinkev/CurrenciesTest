package com.harenko.currencies_test.ui.main

import io.reactivex.Observable

/**
 * Created by egor.kharenko
on 13/09/2018.
 */

fun <T, R> Observable<DataStatus<T>>.mapData(lambda: (T) -> R): Observable<DataStatus<R>> =
        this.map {
            when (it) {
                is DataStatus.Data -> DataStatus.Data(lambda(it.data))
                is DataStatus.Error -> DataStatus.error<R>(it.error)
            }
        }

fun <T> T.toDataStatus(): DataStatus<T> = DataStatus.data(this)

fun <T> Throwable.toDataStatus(): DataStatus<T> = DataStatus.error(this)

fun <T> Observable<T>.toDataStatus(): Observable<DataStatus<T>> = this
        .map { it.toDataStatus() }
        .onErrorResumeNext { t: Throwable -> Observable.just(DataStatus.error(t)) }

fun String.dotsToCommas(): String = this.replace(".", ",")

fun String.commasToDots(): String = this.replace(",", ".")