package com.example.retails.Ui

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.retails.R.layout
import com.example.retails.ViewModelProviderFactory
import com.example.retails.base.BaseActivity

class MainActivity : BaseActivity<MainviewModel>() {
    private var mBlogViewModel = MainviewModel()
    internal var viewModelProviderFactory: ViewModelProviderFactory<*> = ViewModelProviderFactory<Any>(mBlogViewModel)
    override val layoutId: Int
        get() = layout.activity_main

    override fun getViewModel(): MainviewModel {
        mBlogViewModel = ViewModelProviders.of(this, viewModelProviderFactory).get(MainviewModel::class.java)
        return mBlogViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBlogViewModel.fetchBlogs()
    }


}
