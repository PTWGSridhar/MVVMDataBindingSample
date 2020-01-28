package com.example.myapplication2.repository

import com.example.myapplication2.dao.AppDAO
import com.example.myapplication2.dao.AppDaoEnum

public class AppRepository(private val empFakeDao: AppDAO) {
    fun addEmpDao(empData: Any, type: AppDaoEnum) {
        empFakeDao.addEmpData(empData, type)
    }

    fun getEmpDataList() = empFakeDao.getEmpDataList()
    fun getEmpDataInfo() = empFakeDao.getEmpDataInfo()

    companion object {
        @Volatile
        private var instance: AppRepository? = null

        fun getInstance(empFakeDao: AppDAO) = instance ?: synchronized(this) {
            instance ?: AppRepository(empFakeDao).also { instance = it }
        }
    }
}