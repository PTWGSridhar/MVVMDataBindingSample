package com.example.myapplication.viewModel

import androidx.lifecycle.ViewModel
import com.example.myapplication.dao.AppDaoEnum
import com.example.myapplication.dataModel.UserInfoDataModel
import com.example.myapplication.dataModel.UserListDataModel
import com.example.myapplication.repository.AppRepository

class UserInfoDataViewModel (private val empRepository: AppRepository) : ViewModel() {
    fun getEMPFakeDAO() = empRepository.getEmpDataInfo()
    fun addEMPFakeDAO(empData: UserInfoDataModel) = empRepository.addEmpDao(empData,AppDaoEnum.DAOUserInfo)
}