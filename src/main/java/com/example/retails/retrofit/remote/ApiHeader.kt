package com.example.retails.retrofit.remote

import android.accounts.AuthenticatorException
import android.util.Log
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.HashMap


class ApiHeader {

    private var headers = HashMap<String, String>()


    fun getHeaders(): HashMap<String, String> {
        return headers
    }

    fun setHeaders(headers: HashMap<String, String>) {
        this.headers = headers
    }

}

