package com.example.myapplication.backendAPIHandlers

import com.example.myapplication.dataModel.*
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val BaseURL = "https://reqres.in/api/"

interface API {
    @GET("users")
    fun getUserList(@Query("page") page: Int): Single<UserListDataModel>

    @GET("users/{id}")
    fun getUserInfo(@Path("id") page: Int): Single<UserInfoDataModel>
}