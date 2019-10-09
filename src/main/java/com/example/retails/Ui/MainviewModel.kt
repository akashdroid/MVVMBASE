package com.example.retails.Ui

import com.example.retails.base.BaseViewModel
import com.example.retails.retrofit.remote.AppApiHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainviewModel : BaseViewModel<Mainnavigator?>() {
    internal var appApiHelper = AppApiHelper()



    fun fetchBlogs() {
        compositeDisposable.add(appApiHelper.getBlogApiCall()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ blogResponse: List<BlogResponse>? ->
                    if (blogResponse != null) {

                    }
                }, { throwable: Throwable -> }))
    }


    init {
        //fetchBlogs()
    }
}