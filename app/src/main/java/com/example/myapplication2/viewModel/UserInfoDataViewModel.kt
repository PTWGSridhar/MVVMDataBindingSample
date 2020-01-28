package com.example.myapplication2.viewModel

import androidx.lifecycle.ViewModel
import com.example.myapplication2.dao.AppDaoEnum
import com.example.myapplication2.dataModel.UserInfoDataModel
import com.example.myapplication2.dataModel.UserListDataModel
import com.example.myapplication2.repository.AppRepository

class UserInfoDataViewModel (private val empRepository: AppRepository) : ViewModel() {
    fun getEMPFakeDAO() = empRepository.getEmpDataInfo()
    fun addEMPFakeDAO(empData: UserInfoDataModel) = empRepository.addEmpDao(empData,AppDaoEnum.DAOUserInfo)
}