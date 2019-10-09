package com.example.retails.utils

import android.R
import android.graphics.drawable.ColorDrawable
import android.app.ProgressDialog
import android.content.res.AssetManager
import android.util.Patterns
import android.provider.Settings.Secure
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.provider.Settings
import com.example.retails.base.utils.AppConstants
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


object CommonUtils {

    val timestamp: String
        get() = SimpleDateFormat(AppConstants.TIMESTAMP_FORMAT, Locale.US).format(Date())

    @SuppressLint("all")
    fun getDeviceId(context: Context): String {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID)
    }

    fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }


    @Throws(IOException::class)
    fun loadJSONFromAsset(context: Context, jsonFileName: String): String {
        val manager = context.getAssets()
        val `is` = manager.open(jsonFileName)

        val size = `is`.available()
        val buffer = ByteArray(size)
        `is`.read(buffer)
        `is`.close()

        return String(buffer)
    }

    fun showLoadingDialog(context: Context): ProgressDialog {
        val progressDialog = ProgressDialog(context)
        progressDialog.show()
        if (progressDialog.window != null) {
            progressDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
       // progressDialog.setContentView(R.layout.progress_dialoggg)
        progressDialog.isIndeterminate = true
        progressDialog.setCancelable(false)
        progressDialog.setCanceledOnTouchOutside(false)
        return progressDialog
    }
}// This utility class is not publicly instantiable
