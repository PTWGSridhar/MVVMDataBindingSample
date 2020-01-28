package com.example.myapplication.interfaceClass

import com.example.myapplication.backendAPIHandlers.APIType

interface IWebAPIResponse {
    fun onSuccess(response: Any, type: APIType)
    fun onFailure(errorTxt: String)
}