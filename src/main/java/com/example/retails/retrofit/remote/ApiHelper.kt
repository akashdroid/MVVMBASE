package com.example.retails.retrofit.remote

import com.example.retails.Ui.BlogResponse
import io.reactivex.Single

interface ApiHelper {

    fun getBlogApiCall(): Single<List<BlogResponse>>


}