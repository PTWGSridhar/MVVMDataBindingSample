package com.example.myapplication2.interfaceClass

import com.example.myapplication2.backendAPIHandlers.APIType

interface IWebAPIResponse {
    fun onSuccess(response: Any, type: APIType)
    fun onFailure(errorTxt: String)
}