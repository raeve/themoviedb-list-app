package com.rubenexposito.themoviedblistapp.domain

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.Disposables

abstract class BaseUseCase<T>(val observeOn: Scheduler, val subscribeOn: Scheduler) {

    var subscription = Disposables.empty()
    var single: Single<T>? = null

    abstract fun createSingle(data: Map<String, Any>? = null): Single<T>

    internal fun single(withData: Map<String, Any>? = null): Single<T> = createSingle(withData)

    fun execute(callback: Callback<T>, withData: Map<String, Any> = emptyMap()) {
        subscription = createSingle(withData)
            .observeOn(observeOn)
            .subscribeOn(subscribeOn)
            .subscribe({ callback.onCompleted(it) },
                { callback.onError(it) })
    }

    fun clear() {
        if (!subscription.isDisposed)
            subscription.dispose()
    }

    interface Callback<T> {
        fun onCompleted(result: T)
        fun onError(error: Throwable)
    }
}