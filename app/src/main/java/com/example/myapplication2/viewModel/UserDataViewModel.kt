package com.example.myapplication2.viewModel

import androidx.lifecycle.ViewModel
import com.example.myapplication2.dao.AppDaoEnum
import com.example.myapplication2.dataModel.UserListDataModel
import com.example.myapplication2.repository.AppRepository

class UserDataViewModel (private val empRepository: AppRepository) : ViewModel() {
    fun getEMPFakeDAO() = empRepository.getEmpDataList()
    fun addEMPFakeDAO(empData: UserListDataModel) = empRepository.addEmpDao(empData,AppDaoEnum.DAOUserList)
}