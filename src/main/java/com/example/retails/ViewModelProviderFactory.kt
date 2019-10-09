package com.example.retails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.Factory

class ViewModelProviderFactory<V : Any>(private val viewModel: V) : Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(viewModel.javaClass)) {
            return viewModel as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}