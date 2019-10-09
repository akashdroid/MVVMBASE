package com.example.retails.base

import androidx.lifecycle.ViewModel
import com.example.retails.retrofit.remote.AppApiHelper
import com.example.retails.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference


abstract class BaseViewModel<N>() : ViewModel() {

    val isLoading = false

    val compositeDisposable: CompositeDisposable
    private var mNavigator: WeakReference<N>? = null

    var navigator: N
        get() = mNavigator!!.get()!!
        set(navigator) {
            this.mNavigator = WeakReference(navigator)
        }

    init {
        this.compositeDisposable = CompositeDisposable()
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }


}