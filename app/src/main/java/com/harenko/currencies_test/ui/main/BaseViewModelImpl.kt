package com.harenko.currencies_test.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by egor.kharenko
on 24/12/2018.
 */

abstract class BaseViewModelImpl<C> : ViewModel(), BaseViewModel<C> {

    override var screenComponent: C? = null

    protected val compositeDisposable = CompositeDisposable()
    private val operationSet = hashSetOf<Int>()

    override fun onCleared() = compositeDisposable.clear()

    protected fun <M> Observable<M>.trackAndSubscribe(operationId: Int, onNext: (DataStatus<M>) -> Unit) {
        if (!operationSet.contains(operationId)) {
            compositeDisposable.add(this
                    .doFinally { operationSet.remove(operationId) }
                    .doOnSubscribe { operationSet.add(operationId) }
                    .toDataStatus()
                    .subscribe(onNext)
            )
        }
    }
}