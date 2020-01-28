package com.example.myapplication.viewModel.appViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.repository.AppRepository
import com.example.myapplication.viewModel.UserDataViewModel
import com.example.myapplication.viewModel.UserInfoDataViewModel

class AppViewModelFactory(private val empRepository: AppRepository) : ViewModelProvider.NewInstanceFactory() {
    val hashMapViewModel = HashMap<String, ViewModel>()
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(UserDataViewModel::class.java) -> {
                val key = "UserDataViewModel"
                if (hashMapViewModel.containsKey(key)) {
                    return getViewModel(key) as T
                } else {
                    addViewModel(key, UserDataViewModel(empRepository))
                    return getViewModel(key) as T
                }
            }
            modelClass.isAssignableFrom(UserInfoDataViewModel::class.java) -> {
                val key = "UserInfoDataViewModel"
                if (hashMapViewModel.containsKey(key)) {
                    return getViewModel(key) as T
                } else {
                    addViewModel(key, UserInfoDataViewModel(empRepository))
                    return getViewModel(key) as T
                }
            }
            else -> {
                throw IllegalArgumentException("Unknown ViewModel class") as Throwable
            }
        }
    }

    fun addViewModel(key: String, viewModel: ViewModel) {
        hashMapViewModel.put(key, viewModel)
    }

    fun getViewModel(key: String): ViewModel? {
        return hashMapViewModel[key]
    }

}