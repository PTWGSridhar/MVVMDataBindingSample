package com.example.myapplication.viewModel

import androidx.lifecycle.ViewModel
import com.example.myapplication.dao.AppDaoEnum
import com.example.myapplication.dataModel.UserListDataModel
import com.example.myapplication.repository.AppRepository

class UserDataViewModel (private val empRepository: AppRepository) : ViewModel() {
    fun getEMPFakeDAO() = empRepository.getEmpDataList()
    fun addEMPFakeDAO(empData: UserListDataModel) = empRepository.addEmpDao(empData,AppDaoEnum.DAOUserList)
}