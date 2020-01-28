package com.example.myapplication2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication2.adapter.UserListAdapter
import com.example.myapplication2.backendAPIHandlers.APICaller
import com.example.myapplication2.backendAPIHandlers.APIType
import com.example.myapplication2.dataModel.UserListDataModel
import com.example.myapplication2.interfaceClass.IWebAPIResponse
import com.example.myapplication2.interfaceClass.InjectorUtils
import com.example.myapplication2.viewModel.UserDataViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IWebAPIResponse, UserListAdapter.ListItemClick {


    private lateinit var apiCaller: APICaller
    private lateinit var viewModel: UserDataViewModel
    private val TAG = MainActivity::class.java.name
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val injectorUtils = InjectorUtils.provideEMPViewModelFactory()
        viewModel = ViewModelProviders.of(this, injectorUtils).get(UserDataViewModel::class.java)
        apiCaller = APICaller(this@MainActivity)
        apiCaller.callAPI(1, APIType.UserList)
    }

    override fun onSuccess(response: Any, type: APIType) {
        when (type) {
            APIType.UserList -> {
                val userData = response as UserListDataModel
                viewModel.addEMPFakeDAO(userData)
                viewModel.getEMPFakeDAO().observeForever {
                    val dataList = it as List<UserListDataModel>
                    val userList = dataList[0].data
                    listView.layoutManager = LinearLayoutManager(this@MainActivity)
                    listView.adapter = UserListAdapter(
                        this@MainActivity,
                        userList,
                        this@MainActivity
                    )
                    (listView.adapter as UserListAdapter).notifyDataSetChanged()
                    Log.e(TAG, "Load")
                }
            }
        }
    }

    override fun onFailure(errorTxt: String) {

    }

    override fun listItemClick(id: Int) {
        startActivity(Intent(this@MainActivity, UserInfoActivity::class.java).apply {
            putExtra("id", id)
        })
    }
}
