package com.example.myapplication2.dataModel

data class UserListDataModel(
    val page: Long,
    val per_page: Long,
    val total: Long,
    val total_pages: Long,
    val data: List<UserData>
)