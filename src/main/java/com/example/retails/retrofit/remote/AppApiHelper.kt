package com.example.retails.retrofit.remote

import com.example.retails.Ui.BlogResponse
import com.example.retails.Ui.constants.Constants
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single


class AppApiHelper : ApiHelper {
    override fun getBlogApiCall(): Single<List<BlogResponse>> {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_BLOG)
                .addHeaders(Constants.headers)
                .build()
                .getObjectListSingle(BlogResponse::class.java)
    }
}


