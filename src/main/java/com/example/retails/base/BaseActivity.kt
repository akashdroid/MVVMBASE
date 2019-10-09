package com.example.retails.base

import androidx.core.app.ActivityCompat.requestPermissions
import android.os.Build
import android.annotation.TargetApi
import android.R.string.cancel
import android.content.Context.INPUT_METHOD_SERVICE
import androidx.core.content.ContextCompat.getSystemService
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.annotation.LayoutRes
import android.app.ProgressDialog
import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import com.example.retails.utils.CommonUtils
import com.example.retails.utils.NetworkUtils
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper
import androidx.core.content.ContextCompat.getSystemService
import com.example.retails.Ui.constants.Constants


abstract class BaseActivity<V : BaseViewModel<*>> : AppCompatActivity(),
    BaseFragment.Callback {

    // TODO
    // this can probably depend on isLoading variable of BaseViewModel,
    // since its going to be common for all the activities
    private var mProgressDialog: ProgressDialog? = null
    private var mViewModel: V? = null
    /**
     * @return layout resource id
     */
    @get:LayoutRes
    abstract val layoutId: Int

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    abstract fun getViewModel(): V


    val isNetworkConnected: Boolean
        get() = NetworkUtils.isNetworkConnected(applicationContext)

    override fun onFragmentAttached() {

    }

    override fun onFragmentDetached(tag: String) {

    }

    protected override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( layoutId)
        this.mViewModel = if (mViewModel == null) getViewModel() else mViewModel
        val intent = intent
        val hashMap = intent.getSerializableExtra("headers") as HashMap<String, String>
        Constants.headers = hashMap
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun hasPermission(permission: String): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
    }

    fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            if (imm != null) {
                imm!!.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }
    }

    fun hideLoading() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog!!.cancel()
        }
    }

    fun openActivityOnTokenExpire() {
        /* startActivity(LoginActivity.newIntent(this));
        finish();*/
    }



    @TargetApi(Build.VERSION_CODES.M)
    fun requestPermissionsSafely(permissions: Array<String>, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode)
        }
    }

    fun showLoading() {
        hideLoading()
        mProgressDialog = CommonUtils.showLoadingDialog(this)
    }





}