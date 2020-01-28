package com.example.myapplication.interfaceClass

import com.example.myapplication.dao.AppFakeDatabase
import com.example.myapplication.repository.AppRepository
import com.example.myapplication.viewModel.appViewModelFactory.AppViewModelFactory

object InjectorUtils {
    fun provideEMPViewModelFactory(): AppViewModelFactory {
        val quoteRepository = AppRepository.getInstance(AppFakeDatabase.getInstance().empFakeDao)
        return AppViewModelFactory(quoteRepository)
    }
}