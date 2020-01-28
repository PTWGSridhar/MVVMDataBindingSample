package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.dataModel.UserData
import com.example.myapplication.databinding.UserViewDataBinding


class UserListAdapter(val context: Context, val listData: List<UserData>, val click: ListItemClick) :
    RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {
    private var layoutInflater: LayoutInflater? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(context);
        }
        val dataBindUnit = UserViewDataBinding.inflate(layoutInflater!!, parent, false)
        return UserViewHolder(dataBindUnit)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindData(listData[position])
    }

    inner class UserViewHolder(val viewModelDataBinding: UserViewDataBinding) :
        RecyclerView.ViewHolder(viewModelDataBinding.root) {
        fun bindData(data: UserData) {
            this.viewModelDataBinding.userData = data
            
            viewModelDataBinding.root.setOnClickListener {
                click.listItemClick(data.id)
            }
        }
    }

    interface ListItemClick {
        fun listItemClick(id: Int)
    }
}