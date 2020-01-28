package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.backendAPIHandlers.APICaller
import com.example.myapplication.backendAPIHandlers.APIType
import com.example.myapplication.dataModel.UserInfoDataModel
import com.example.myapplication.databinding.UserInfoDatBind
import com.example.myapplication.interfaceClass.IWebAPIResponse
import com.example.myapplication.interfaceClass.InjectorUtils
import com.example.myapplication.viewModel.UserInfoDataViewModel

class UserInfoActivity : AppCompatActivity(), IWebAPIResponse {
    private lateinit var apiCaller: APICaller
    private lateinit var viewModel: UserInfoDataViewModel
    private lateinit var binding: UserInfoDatBind
    private val TAG = UserInfoActivity::class.java.name
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_info)
        val injectorUtils = InjectorUtils.provideEMPViewModelFactory()
        viewModel = ViewModelProviders.of(this, injectorUtils).get(UserInfoDataViewModel::class.java)
        apiCaller = APICaller(this@UserInfoActivity)
        intent.extras!!.getInt("id")?.let {
            Log.e(TAG, "EMP Id:- $it")
            apiCaller.callAPI(it, APIType.UserInfo)
        }
    }

    override fun onSuccess(response: Any, type: APIType) {
        when (type) {
            APIType.UserInfo -> {
                val userData = response as UserInfoDataModel
                viewModel.addEMPFakeDAO(userData)
                viewModel.getEMPFakeDAO().observeForever {
                    if (it.size != 0) {
                        viewModel.getEMPFakeDAO().observeForever {
                            val dataList = it as List<UserInfoDataModel>
                            val userList = dataList[0].data
                            binding.userData = userList
                        }

                    }
                }
            }
        }
    }

    override fun onFailure(errorTxt: String) {

    }
}
