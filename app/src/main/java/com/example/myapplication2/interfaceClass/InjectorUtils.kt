package com.example.myapplication2.interfaceClass

import com.example.myapplication2.dao.AppFakeDatabase
import com.example.myapplication2.repository.AppRepository
import com.example.myapplication2.viewModel.appViewModelFactory.AppViewModelFactory

object InjectorUtils {
    fun provideEMPViewModelFactory(): AppViewModelFactory {
        val quoteRepository = AppRepository.getInstance(AppFakeDatabase.getInstance().empFakeDao)
        return AppViewModelFactory(quoteRepository)
    }
}